package com.cts.tsp.service.provision;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.tsp.dao.provision.TokenPrefixCounterDAO;
import com.cts.tsp.domain.TokenPrefixCounter;

@Service
@Transactional
public class TokenPrefixServiceImpl implements TokenPrefixService{

	@Autowired
	private TokenPrefixCounterDAO tokenPrefixCounterDAO; 
	
	@Override
	public String getNextToken(String tokenPrefix) {
		
		TokenPrefixCounter tokenPrefixCounter = tokenPrefixCounterDAO.getCounterByTokenPrefix(tokenPrefix);
		if(tokenPrefixCounter == null){
			tokenPrefixCounter = new TokenPrefixCounter();
			tokenPrefixCounter.setCounter(1);
			tokenPrefixCounter.setTokenBin(tokenPrefix);
			tokenPrefixCounterDAO.create(tokenPrefixCounter);
		}else{
			tokenPrefixCounter.setCounter(tokenPrefixCounter.getCounter()+1);
			tokenPrefixCounterDAO.update(tokenPrefixCounter);
		}
		return tokenPrefix + String.format("%0" + (15 - tokenPrefix.length()) + "d",tokenPrefixCounter.getCounter()); 
	}
	
}
