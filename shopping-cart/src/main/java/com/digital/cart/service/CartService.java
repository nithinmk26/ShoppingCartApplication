/**
 * 
 */
package com.digital.cart.service;

import com.digital.cart.dto.ShopResponse;
import com.digital.cart.exception.ShoppingException;

/**
 * @author M1056182
 *
 */
public interface CartService {


	ShopResponse putIntoBucket(int userId, int productId) throws ShoppingException;

	ShopResponse viewCart(int userId) throws ShoppingException;

	ShopResponse removeCartItem(int userId, int productId) throws ShoppingException;

	ShopResponse removeCart(int userId) throws ShoppingException;

	ShopResponse updateCart(int userId, int productId, int updateQuantity) throws ShoppingException;


}
