/**
 * 
 */
package com.mindtree.cart.dao;

import com.mindtree.cart.entity.Cart;

/**
 * @author M1056182
 *
 */
public interface cartDao {

	void createCart(Cart cart);

	Cart fetchCart(int cartId);

	void updateCart(Cart cart);

	void deleteCart(int cartId);

	

}
