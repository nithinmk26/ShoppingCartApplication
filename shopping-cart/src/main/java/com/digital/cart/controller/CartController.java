/**
 * 
 */
package com.digital.cart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digital.cart.dto.ShopResponse;
import com.digital.cart.exception.ShoppingException;
import com.digital.cart.service.CartService;

/**
 * @author M1056182
 *
 */
@RestController
public class CartController {
	
	@Autowired
	private CartService cartService;
		
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@RequestMapping(value = "/putIntoBucket/{userId}/{productId}", method = RequestMethod.POST)
	public ResponseEntity<ShopResponse> putIntoBucket(@PathVariable int userId, @PathVariable int productId) throws ShoppingException {
		logger.info("---> Adding Items into Cart...!");
		return new ResponseEntity<ShopResponse>(cartService.putIntoBucket(userId,productId),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/viewCart/{userId}", method = RequestMethod.GET)
	public ResponseEntity<ShopResponse> viewCart(@PathVariable int userId) throws ShoppingException{
		logger.info("---> View Items present in a cart...!");
		return new ResponseEntity<ShopResponse>(cartService.viewCart(userId),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/removeCartItem/{userId}/{productId}",method = RequestMethod.POST)
	public ResponseEntity<ShopResponse> removeCartItem(@PathVariable int userId, @PathVariable int productId) throws ShoppingException{
		logger.info("---> remove particular items from cart...!");
		return new ResponseEntity<ShopResponse>(cartService.removeCartItem(userId,productId),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/removeCart/{userId}",method = RequestMethod.POST)
	public ResponseEntity<ShopResponse> removeCart(@PathVariable int userId) throws ShoppingException{
		logger.info("---> remove entire cart...!");
		return new ResponseEntity<ShopResponse>(cartService.removeCart(userId),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateCart/{userId}/{productId}/{updateQuantity}", method = RequestMethod.POST)
	public ResponseEntity<ShopResponse> updateCart(@PathVariable int userId,@PathVariable int productId, @PathVariable int updateQuantity) throws ShoppingException{
		logger.info("---> update cart for particular userId and productId...!");
		return new ResponseEntity<ShopResponse>(cartService.updateCart(userId,productId,updateQuantity),HttpStatus.OK);
	}
	

}
