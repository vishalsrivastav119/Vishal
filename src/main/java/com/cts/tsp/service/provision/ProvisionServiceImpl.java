/**
 * 
 */
package com.cts.tsp.service.provision;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.tsp.dao.issuer.IssuerProdTypeAidVersionDAO;
import com.cts.tsp.dao.issuer.IssuerProductTypeDAO;
import com.cts.tsp.dao.issuer.ProductTypeDAO;
import com.cts.tsp.dao.issuer.TokenBinRangeDAO;
import com.cts.tsp.dao.provision.IssuerTokenRequestorAttributeDAO;
import com.cts.tsp.dao.provision.IssuerTokenRequestorBinRangeDAO;
import com.cts.tsp.dao.provision.TokenPrefixCounterDAO;
import com.cts.tsp.dao.provision.TokenProvisionRequestQueueDAO;
import com.cts.tsp.domain.FundingBinRange;
import com.cts.tsp.domain.IssuerProdTypeAidVersion;
import com.cts.tsp.domain.IssuerProductType;
import com.cts.tsp.domain.IssuerTokenRequestorAttribute;
import com.cts.tsp.domain.IssuerTokenRequestorTokenBinRange;
import com.cts.tsp.domain.TokenProvisionContent;
import com.cts.tsp.domain.TokenProvisionRequestQueue;
import com.cts.tsp.domain.enumerations.ProvisionStatus;
import com.cts.tsp.dto.provision.NetworkCheckCardRequestDTO;
import com.cts.tsp.dto.provision.NetworkCheckCardResponseDTO;
import com.cts.tsp.dto.provision.ProvisionCardRequestDTO;
import com.cts.tsp.dto.provision.ProvisionCardResponseDTO;
import com.cts.tsp.dto.provision.ProvisionRequestContentDTO;
import com.cts.tsp.exception.ApplicationException;
import com.cts.tsp.exception.ErrorCode;
import com.cts.tsp.util.Util;

/**
 * @author Somnath
 * 
 */
@Service
@Transactional
public class ProvisionServiceImpl implements ProvisionService {

	@Autowired
	private TokenBinRangeDAO tokenBinRangeDAO;

	@Autowired
	private TokenProvisionRequestQueueDAO tokenProvisionRequestQueueDAO;

	@Autowired
	private IssuerTokenRequestorBinRangeDAO issuerTokenRequestorBinRangeDAO;

	@Autowired
	private ProductTypeDAO productTypeDAO;

	@Autowired
	private IssuerProdTypeAidVersionDAO issuerProdTypeAidVersionDAO;

	@Autowired
	private IssuerTokenRequestorAttributeDAO issuerTokenRequestorAttributeDAO;

	@Autowired
	private IssuerProductTypeDAO issuerProductTypeDAO;

	@Autowired
	private TokenPrefixCounterDAO tokenPrefixCounterDAOImpl;

	@Autowired
	private TokenPrefixService tokenPrefixService;
	
	@Autowired
	private TokenPoolService tokenPoolService;

	public NetworkCheckCardResponseDTO networkCheckCard(
			NetworkCheckCardRequestDTO request) {
		// Check if either of the FPANID or the FPAN is present in this request,
		// if not terminate

		if ((request.getFundingPan() == null || request.getFundingPan().trim()
				.isEmpty())
				&& (request.getFundingPanId() == null || request
						.getFundingPanId().trim().isEmpty())) {

			// decode the exception using the mappin table. This is format error
			ApplicationException appException = new ApplicationException(
					ErrorCode.ERR_40000);
			throw appException;
		}

		// check if the funding pan is a valid card number
		if (!request.getFundingPan()
				.equals(Util.getLuhnValidated(request.getFundingPan()
						.substring(0, 15)))) {
			// decode the exception using the mappin table. This is format error
			ApplicationException appException = new ApplicationException(
					ErrorCode.ERR_40001);
			throw appException;
		}

		IssuerProductType issuerProductTypes = issuerProductTypeDAO
				.findIssuerProductTypeByProductType(request.getProductType());
		if(issuerProductTypes == null){
			throw new ApplicationException(ErrorCode.ERR_40013);
		}
		List<FundingBinRange> fundingBinRanges = issuerProductTypes
				.getT457FundingBinRanges();

		
		Boolean isFPanValid = false;
		for (FundingBinRange fundingBinRange : fundingBinRanges) {
			Long fpan = Long.parseLong(request.getFundingPan());
			if (fpan <= fundingBinRange.getFundingBinRangeEnd()
					&& fpan >= fundingBinRange.getFundingBinRangeStart()) {
				isFPanValid = true;
			}
		}

		if (!isFPanValid) {
			throw new ApplicationException(ErrorCode.ERR_40001);
		}

		// split this into 2 sparate calls
		IssuerTokenRequestorTokenBinRange issuerRequestorTokenBinRange = issuerTokenRequestorBinRangeDAO
				.findTokenBinRangeByRequestor(request.getRequestor());
		
		if(issuerRequestorTokenBinRange == null){
			throw new ApplicationException(ErrorCode.ERR_40013);
		}

		System.out
				.println("issuerRequestorTokenBinRange.getTokenBinRange().getTokenBinRangeStart()::"
						+ issuerRequestorTokenBinRange.getTokenBinRange()
								.getTokenBinRangeStart());
		System.out
				.println("issuerRequestorTokenBinRange.getTokenBinRange().getTokenBinRangeEnd()::"
						+ issuerRequestorTokenBinRange.getTokenBinRange()
								.getTokenBinRangeEnd());

		// This is the generated token number
		String validatedToken = tokenPoolService.assignToken(String.valueOf(
				issuerRequestorTokenBinRange.getTokenBinRange()
						.getTokenBinRangeStart()).substring(0, 6));

		// Validate the AID Version
		Boolean isValidAID = false;
		List<IssuerProdTypeAidVersion> issuerProdTypeAidVersions = issuerProdTypeAidVersionDAO
				.getDetailsByAID(request.getAid());
		for (IssuerProdTypeAidVersion aidVersion : issuerProdTypeAidVersions) {
			if (aidVersion.getT466AidVersion().getVersion()
					.equals(request.getAidVersion())) {
				System.out.println("Valid AID version");
				isValidAID = true;
			}
		}

		// 4002
		if (!isValidAID) {
			throw new ApplicationException(ErrorCode.ERR_40002);
		}
		
		List<TokenProvisionRequestQueue> pendingRequests = tokenProvisionRequestQueueDAO.getRequestQueueItemByFPan(request.getFundingPan());

		if(pendingRequests!=null && pendingRequests.size() > 0){
			throw new ApplicationException(ErrorCode.ERR_40001);
		}
		// Invalid Field

		// Build the request queue object here
		TokenProvisionRequestQueue requestQueue = new TokenProvisionRequestQueue();

		requestQueue.setFpan(request.getFundingPan());
		requestQueue.setFpanExpDate(request.getPanExpiryDate());
		// This set what should be the values
		// requestQueue.setNextStepToken();
		requestQueue.setPanSource(request.getfPanSource());
		requestQueue.setToken(validatedToken);
		// Get this Calculation right
		Calendar tokenExpiryDate = Calendar.getInstance();
		tokenExpiryDate.add(Calendar.DAY_OF_YEAR, 30);
		requestQueue.setTokenExpDate(tokenExpiryDate.getTime());
		requestQueue.setTokenRequestor(request.getRequestor());
		requestQueue.setNextStepToken(UUID.randomUUID().toString());

		// What value should go in here?
		// requestQueue.setTokenType(tokenType);
		requestQueue.setTokenProvisionStts("SUCCESS");

		// now build the the IssuerTokenRequestorAttributes
		List<IssuerTokenRequestorAttribute> issuerAttributes = issuerTokenRequestorAttributeDAO
				.findAllAttributesForRequestor(request.getRequestor());

		// Insert into Queue Content
		// TTL to be exteranlized on a table
		List<TokenProvisionContent> contentList = new ArrayList<TokenProvisionContent>();
		for (IssuerTokenRequestorAttribute issuerAttribute : issuerAttributes) {
			if (issuerAttribute.getT463TokenRequestorAttribute()
					.getGuidRequired()) {
				TokenProvisionContent content = new TokenProvisionContent();
				content.setAttributeName(issuerAttribute
						.getT463TokenRequestorAttribute()
						.getTokenRequestorAttributeName());
				content.setAttributeValue(issuerAttribute
						.getTokenRqstrAttributeValue());
				content.setRequestQueue(requestQueue);
				content.setTokenProvisionContGuiId(UUID.randomUUID().toString());
				contentList.add(content);
			}
		}

		requestQueue.setTokenProvisionContents(contentList);
		tokenProvisionRequestQueueDAO.create(requestQueue);

		NetworkCheckCardResponseDTO response = new NetworkCheckCardResponseDTO();
//		response.setToken(requestQueue.getToken());
//		response.setTokenExpiryDate(requestQueue.getTokenExpDate());
//		response.setContentAttributes(new ArrayList<ProvisionRequestContentDTO>());
//		response.setPanReferenceId(UUID.randomUUID().toString());
//		response.setTokenReferenceNo(UUID.randomUUID().toString());
//		for (TokenProvisionContent content : contentList) {
//			ProvisionRequestContentDTO provisionRequestContentDTO = new ProvisionRequestContentDTO();
//			provisionRequestContentDTO.setAttributeName(content
//					.getAttributeName());
//			provisionRequestContentDTO.setGUID(content
//					.getTokenProvisionContGuiId());
//			response.getContentAttributes().add(provisionRequestContentDTO);
//		}
		
		String fPANId = UUID.randomUUID().toString();
		
		response.setNextStepToken(requestQueue.getNextStepToken());
		response.setdPANId(requestQueue.getToken());
		response.setfPANId(fPANId);
		response.setfPANReference(fPANId);
		response.setdPANReference(requestQueue.getToken());
		response.setNextStepTokenTTL(30*24*60*60L);
		return response;
	}
	
	public ProvisionCardResponseDTO provisionCard(ProvisionCardRequestDTO provisionCardRequest){

		if ((provisionCardRequest.getCardInfo() == null || provisionCardRequest.getCardInfo().getPan() == null || provisionCardRequest.getCardInfo().getPan().trim()
				.isEmpty())) {
			// decode the exception using the mappin table. This is format error
			ApplicationException appException = new ApplicationException(
					ErrorCode.ERR_40000);
			throw appException;
		}

		// check if the funding pan is a valid card number
		if (!provisionCardRequest.getCardInfo().getPan()
				.equals(Util.getLuhnValidated(provisionCardRequest.getCardInfo().getPan()
						.substring(0, 15)))) {
			// decode the exception using the mappin table. This is format error
			ApplicationException appException = new ApplicationException(
					ErrorCode.ERR_40001);
			throw appException;
		}

		IssuerProductType issuerProductTypes = issuerProductTypeDAO
				.findIssuerProductTypeByProductType(provisionCardRequest.getProductType());
		if(issuerProductTypes == null){
			throw new ApplicationException(ErrorCode.ERR_40013);
		}
		List<FundingBinRange> fundingBinRanges = issuerProductTypes
				.getT457FundingBinRanges();

		
		Boolean isFPanValid = false;
		for (FundingBinRange fundingBinRange : fundingBinRanges) {
			Long fpan = Long.parseLong(provisionCardRequest.getCardInfo().getPan());
			if (fpan <= fundingBinRange.getFundingBinRangeEnd()
					&& fpan >= fundingBinRange.getFundingBinRangeStart()) {
				isFPanValid = true;
			}
		}

		if (!isFPanValid) {
			throw new ApplicationException(ErrorCode.ERR_40001);
		}

		// split this into 2 sparate calls
		IssuerTokenRequestorTokenBinRange issuerRequestorTokenBinRange = issuerTokenRequestorBinRangeDAO
				.findTokenBinRangeByRequestor(provisionCardRequest.getRequestor());
		
		if(issuerRequestorTokenBinRange == null){
			throw new ApplicationException(ErrorCode.ERR_40013);
		}

		System.out
				.println("issuerRequestorTokenBinRange.getTokenBinRange().getTokenBinRangeStart()::"
						+ issuerRequestorTokenBinRange.getTokenBinRange()
								.getTokenBinRangeStart());
		System.out
				.println("issuerRequestorTokenBinRange.getTokenBinRange().getTokenBinRangeEnd()::"
						+ issuerRequestorTokenBinRange.getTokenBinRange()
								.getTokenBinRangeEnd());

		// This is the generated token number
		String validatedToken = tokenPoolService.assignToken(String.valueOf(
				issuerRequestorTokenBinRange.getTokenBinRange()
						.getTokenBinRangeStart()).substring(0, 6));

		// Validate the AID Version
		Boolean isValidAID = false;
		List<IssuerProdTypeAidVersion> issuerProdTypeAidVersions = issuerProdTypeAidVersionDAO
				.getDetailsByAID(provisionCardRequest.getAid());
		for (IssuerProdTypeAidVersion aidVersion : issuerProdTypeAidVersions) {
			if (aidVersion.getT466AidVersion().getVersion()
					.equals(provisionCardRequest.getAidVersion())) {
				System.out.println("Valid AID version");
				isValidAID = true;
			}
		}

		// 4002
		if (!isValidAID) {
			throw new ApplicationException(ErrorCode.ERR_40002);
		}
		
		List<TokenProvisionRequestQueue> pendingRequests = tokenProvisionRequestQueueDAO.getRequestQueueItemByFPan(provisionCardRequest.getCardInfo().getPan());

		if(pendingRequests!=null && pendingRequests.size() > 0){
			throw new ApplicationException(ErrorCode.ERR_40001);
		}
		// Invalid Field

		// Build the request queue object here
		TokenProvisionRequestQueue requestQueue = new TokenProvisionRequestQueue();

		requestQueue.setFpan(provisionCardRequest.getCardInfo().getPan());
		requestQueue.setFpanExpDate(provisionCardRequest.getCardInfo().getPanExpiryDate());
		// This set what should be the values
		// requestQueue.setNextStepToken();
		requestQueue.setPanSource(provisionCardRequest.getPanSource());
		requestQueue.setToken(validatedToken);
		// Get this Calculation right
		Calendar tokenExpiryDate = Calendar.getInstance();
		tokenExpiryDate.add(Calendar.DAY_OF_YEAR, 30);
		requestQueue.setTokenExpDate(tokenExpiryDate.getTime());
		requestQueue.setTokenRequestor(provisionCardRequest.getRequestor());
		requestQueue.setNextStepToken(UUID.randomUUID().toString());

		// What value should go in here?
		// requestQueue.setTokenType(tokenType);
		requestQueue.setTokenProvisionStts("SUCCESS");

		// now build the the IssuerTokenRequestorAttributes
		List<IssuerTokenRequestorAttribute> issuerAttributes = issuerTokenRequestorAttributeDAO
				.findAllAttributesForRequestor(provisionCardRequest.getRequestor());

		// Insert into Queue Content
		// TTL to be exteranlized on a table
		List<TokenProvisionContent> contentList = new ArrayList<TokenProvisionContent>();
		for (IssuerTokenRequestorAttribute issuerAttribute : issuerAttributes) {
			if (issuerAttribute.getT463TokenRequestorAttribute()
					.getGuidRequired()) {
				TokenProvisionContent content = new TokenProvisionContent();
				content.setAttributeName(issuerAttribute
						.getT463TokenRequestorAttribute()
						.getTokenRequestorAttributeName());
				content.setAttributeValue(issuerAttribute
						.getTokenRqstrAttributeValue());
				content.setRequestQueue(requestQueue);
				content.setTokenProvisionContGuiId(UUID.randomUUID().toString());
				contentList.add(content);
			}
		}

		requestQueue.setTokenProvisionContents(contentList);
		tokenProvisionRequestQueueDAO.create(requestQueue);

		ProvisionCardResponseDTO response = new ProvisionCardResponseDTO();
//		response.setToken(requestQueue.getToken());
//		response.setTokenExpiryDate(requestQueue.getTokenExpDate());
//		response.setContentAttributes(new ArrayList<ProvisionRequestContentDTO>());
//		response.setPanReferenceId(UUID.randomUUID().toString());
//		response.setTokenReferenceNo(UUID.randomUUID().toString());
//		for (TokenProvisionContent content : contentList) {
//			ProvisionRequestContentDTO provisionRequestContentDTO = new ProvisionRequestContentDTO();
//			provisionRequestContentDTO.setAttributeName(content
//					.getAttributeName());
//			provisionRequestContentDTO.setGUID(content
//					.getTokenProvisionContGuiId());
//			response.getContentAttributes().add(provisionRequestContentDTO);
//		}
		
		String fPANId = UUID.randomUUID().toString();
		response.setProvisionId(fPANId);
		response.setStatus(ProvisionStatus.ACTIVE);
		response.setNextStepToken(requestQueue.getNextStepToken());
		response.setToken(requestQueue.getToken());
		response.setNextStepTokenTTL(30*24*60*60L);
		return response;
	}
}
