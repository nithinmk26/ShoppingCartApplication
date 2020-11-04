/**
 * 
 */
package com.mindtree.cart.dao;

import com.mindtree.cart.entity.User;

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
