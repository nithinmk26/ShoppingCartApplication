/**
 * 
 */
package com.mindtree.cart.dao.daoimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.cart.dao.cartDao;
import com.mindtree.cart.entity.Cart;
import com.mindtree.cart.repository.CartRepository;

/**
 * @author M1056182
 *
 */
@Service
public class CartDaoImpl implements cartDao{

	@Autowired
	private CartRepository cartRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(CartDaoImpl.class);
	
	@Override
	public void createCart(Cart cart) {
		logger.info("---> creating a cart in repo..>!");
		cartRepository.save(cart);
	}

	@Override
	public Cart fetchCart(int cartId) {
		logger.info("----> Fetching a cart ..!");
		return cartRepository.findById(cartId).get();
	}

	@Override
	public void updateCart(Cart cart) {
		logger.info("---> Updating a cart..!");
		cartRepository.saveAndFlush(cart);
	}

	@Override
	public void deleteCart(int cartId) {
		logger.info("---> Delete a cart By id...!");
		cartRepository.deleteById(cartId);
	}


 
}
