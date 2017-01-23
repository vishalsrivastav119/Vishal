/** 
 * Logging Interceptor class that provides entry and exit logs 
 */
package com.cts.tsp.util;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author 111033
 * 
 */
@Aspect
public class LogInterceptor {
	private Logger log = Logger.getLogger("LogInterceptor");
			
	/**
	 * @param point
	 */
	@After("execution(* com.firstdata.networkoptimiser.service..*(..))")
	public void logAfter(JoinPoint point) {
		log.info(point.getSignature().getClass() + ":" + point.getSignature().getName() + " existing");
	}
	
	/**
	 * @param point
	 */
	@Before("execution(* com.firstdata.networkoptimiser.service..*(..))")
	public void logBefore(JoinPoint point) {
		log.info(point.getSignature().getClass() + ":" + point.getSignature().getName() + " entering...");
	}
	
	public static void main(String[] args) {
		String text = "java.sql.SQLException:ORA-01000: maximum open cursors exceeded";
		System.out.println(text.contains("ORA-01000"));
	}
}