/**
 * 
 */
package com.mindtree.cart.service;

import com.mindtree.cart.dto.UserDto;
import com.mindtree.cart.entity.User;
import com.mindtree.cart.exception.ShoppingException;

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
