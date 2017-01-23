/**
 * 
 */
package com.cts.tsp.service.provision;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.tsp.dao.provision.TokenPoolDAO;
import com.cts.tsp.domain.TokenPool;
import com.cts.tsp.domain.TokenStatus;
import com.cts.tsp.util.Util;

/**
 * @author Somnath
 *
 */
@Service

public class TokenPoolServiceImpl implements TokenPoolService{
	
	@Autowired
	private TokenPrefixService tokenPrefixService;
	
	@Autowired
	private TokenPoolDAO tokenPoolDAO;

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void replenishToken(String tokenBin){
		Integer numberOfActiveTokens = tokenPoolDAO.getActiveTokens(tokenBin).size();
		
		if(numberOfActiveTokens  < 100){
			for(int i=numberOfActiveTokens;i<100;++i){
				String token = Util.getLuhnValidated(tokenPrefixService.getNextToken(tokenBin));
				TokenPool tokenPool = new TokenPool();
				tokenPool.setToken(token);
				tokenPool.setTokenBin(tokenBin);
				tokenPool.setStatus(TokenStatus.CREATED);
				tokenPoolDAO.create(tokenPool);
			}
		}
	}

	@Transactional
	public String assignToken(String tokenBin){
		replenishToken(tokenBin);
		List<TokenPool> tokenPool = tokenPoolDAO.getActiveTokens(tokenBin);
		TokenPool tokenPoolItem = tokenPool.get((int)(Math.random()*tokenPool.size()));
		tokenPoolItem.setStatus(TokenStatus.ASSIGNED);
		tokenPoolDAO.update(tokenPoolItem);
		return tokenPoolItem.getToken();
	}
}
