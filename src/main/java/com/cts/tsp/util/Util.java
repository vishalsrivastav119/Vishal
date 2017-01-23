package com.cts.tsp.util;


public class Util {

	public static Long generateRandomToken(Long minValue, Long maxValue) {		
		double randomValue = (Math.random() * (maxValue - minValue)) ;
		return (long)randomValue+minValue; 
	}

	public static String getLuhnValidated(String cardPrefix) {
		Integer sum = 0;
	    for (int i=0; i<cardPrefix.length(); i++ )
	    {
			sum += Integer.parseInt(cardPrefix.substring(i,i+1));
	    }
		Integer[] delta = new Integer[]{0,1,2,3,4,-4,-3,-2,-1,0};
		for (int i=cardPrefix.length()-1; i>=0; i-=2 )
	    {		
			Integer deltaIndex = Integer.parseInt(cardPrefix.substring(i,i+1));
			Integer deltaValue = delta[deltaIndex];	
			sum += deltaValue;
		}	
		Integer mod10 = sum % 10;
		mod10 = 10 - mod10;	
		if (mod10==10)
		{		
			mod10=0;
		}
		return cardPrefix + mod10;
	}
}