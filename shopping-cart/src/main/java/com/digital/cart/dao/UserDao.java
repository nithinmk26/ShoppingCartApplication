/**
 * 
 */
package com.digital.cart.dao;

import com.digital.cart.entity.User;

/**
 * @author M1056182
 *
 */
public interface UserDao {

	User registerUser(User user);

	boolean isPresent(int userId);

	User fetchUser(int userId);

	void createCart(User user);

	void updateUser(User user);

}
