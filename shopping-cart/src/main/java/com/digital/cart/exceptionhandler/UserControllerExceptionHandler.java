/**
 * 
 */
package com.digital.cart.exceptionhandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.digital.cart.controller.UserController;
import com.digital.cart.exception.ShoppingException;

/**
 * @author M1056182
 *
 */
@RestControllerAdvice(assignableTypes = UserController.class )
public class UserControllerExceptionHandler {
	
	@ExceptionHandler(ShoppingException.class)
	public ResponseEntity<Map<String, Object>> userControllerException(Exception e, Throwable t) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("Error", true);
		response.put("Message", e.getMessage());
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
	}

}
