/**
 * 
 */
package com.cts.tsp.rest.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.cts.tsp.exception.ApplicationException;
import com.cts.tsp.util.ExceptionMessageTranslator;

/**
 * @author 111033
 *
 */
@Provider
public class ApplicationExceptionHandler implements ExceptionMapper<ApplicationException> {
	private static final Logger log= LogManager.getLogger(ApplicationExceptionHandler.class);
	
	@Autowired
	private ExceptionMessageTranslator exceptionMessageTranslator;

	/* (non-Javadoc)
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(ApplicationException exception) {
		exceptionMessageTranslator.enrichMessage(exception);
		
		log.error(exception);
		
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorContract(exception))
                .type(MediaType.APPLICATION_JSON).
                build();
	}
}