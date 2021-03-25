/**
 * 
 */
package com.digital.cart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digital.cart.dto.UserDto;
import com.digital.cart.exception.ShoppingException;
import com.digital.cart.service.UserService;

/**
 * @author M1056182
 *
 */
@RestController
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) throws ShoppingException{
		logger.info("---> User Registration Process Started...!");
		return new ResponseEntity<UserDto>(userService.registerUser(userDto),HttpStatus.OK);
	}
	

}
