package net.roundya.restlayer.errorhandling;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.roundya.restlayer.errorhandling.ExceptionResponse;
import net.roundya.restlayer.errorhandling.UserNameExistsException;

@ControllerAdvice
public class UsernameExistsExceptionProcessor {

	@ExceptionHandler(UserNameExistsException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ResponseBody    
	public ExceptionResponse userNameExists(final UserNameExistsException exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());

		return error;
	}    
 
}