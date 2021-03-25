/**
 * 
 */
package com.digital.cart.service;

import com.digital.cart.dto.UserDto;
import com.digital.cart.entity.User;
import com.digital.cart.exception.ShoppingException;

/**
 * @author M1056182
 *
 */
public interface UserService {

	UserDto registerUser(UserDto userDto) throws ShoppingException;

	User fetchUser(int userId) throws ShoppingException;

	void createCart(User user);

	void updateUser(User user);
	
	

}
