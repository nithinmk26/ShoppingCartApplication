/**
 * 
 */
package com.digital.cart.service.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.cart.contants.ShoppingConstants;
import com.digital.cart.dao.cartDao;
import com.digital.cart.dto.ShopResponse;
import com.digital.cart.entity.Cart;
import com.digital.cart.entity.Product;
import com.digital.cart.entity.User;
import com.digital.cart.exception.ProductNotBelongs;
import com.digital.cart.exception.ProductUnavailableException;
import com.digital.cart.exception.QuantityNotInLimitException;
import com.digital.cart.exception.ShoppingException;
import com.digital.cart.service.CartService;
import com.digital.cart.service.ProductService;
import com.digital.cart.service.UserService;

/**
 * @author M1056182
 *
 */
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private ProductService productService;

	@Autowired
	private cartDao cartDao;

	@Autowired
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

	private ShopResponse shop = new ShopResponse();

	@Override
	public ShopResponse putIntoBucket(int userId, int productId) throws ShoppingException {
		logger.info("---> Adding into Cart in impl");
		Product product = productService.fetchProduct(productId);
		Cart cart;
		User user = userService.fetchUser(userId);

		if (!((product.getCart() == null) || (user.getCart() == product.getCart()))) {
			logger.error("---> product not available...!");
			throw new ProductUnavailableException(ShoppingConstants.PRODUCT_UNAVAILABLE);
		}

		if (user.getCart() == null) {
			cart = new Cart();
			user.setCart(cart);
			cart.setCartValue(cart.getCartValue() + (double) product.getPrice());
			cartDao.createCart(cart);
			product.setCart(cart);
			product.setQuantity(1);
			productService.updateProduct(product);
		}

		else {
			cart = cartDao.fetchCart(user.getCart().getCartId());
			cart.setCartValue(cart.getCartValue() + (double) product.getPrice());
			cartDao.updateCart(cart);
			product.setQuantity(product.getQuantity() + 1);
			product.setCart(cart);
			productService.updateProduct(product);
		}
		logger.info("---> product added to cart successfully...!");
		shop.setResult("Product Added to Cart SuccessFully..!");
		return shop;
	}

	@Override
	public ShopResponse viewCart(int userId) throws ShoppingException {
		logger.info("---> view items in cart impl...!");
		User user = userService.fetchUser(userId);
		shop.setResult("List Of Products in Cart..!");
		shop.setObject(user.getCart().getProductList());
		logger.info("return list of items in cart..!");
		return shop;
	}

	@Override
	public ShopResponse removeCartItem(int userId, int productId) throws ShoppingException {
		logger.info("---> remove cart Items from user cart...!");
		User user = userService.fetchUser(userId);
		Cart cart = cartDao.fetchCart(user.getCart().getCartId());
		Product product = productService.fetchProduct(productId);
		if (!(product.getCart().getCartId() == cart.getCartId())) {
			logger.info("---> Product does not belong to user cart...!");
			throw new ProductNotBelongs(ShoppingConstants.PRODUCT_NOT_BELONGS);
		}
		double priceProduct = (double) product.getQuantity() * product.getPrice();
		cart.setCartValue(cart.getCartValue() - priceProduct);
		cartDao.updateCart(cart);
		product.setCart(null);
		product.setQuantity(0);
		productService.updateProduct(product);
		logger.info("---> Product Removed from cart Succesfully..!");
		shop.setResult("Product Removed From cart Successfully..!");
		return shop;
	}

	@Override
	public ShopResponse removeCart(int userId) throws ShoppingException {
		logger.info("---> remove entire cart in impl...!");
		User user = userService.fetchUser(userId);
		int cartId = user.getCart().getCartId();
		user.setCart(null);
		userService.updateUser(user);
		cartDao.deleteCart(cartId);
		logger.info("---> Removed entire cart from user");
		shop.setResult("Cart for UserId - " + userId + "  Has been removed SuccessFully..!");
		return shop;
	}

	@Override
	public ShopResponse updateCart(int userId, int productId, int updateQuantity) throws ShoppingException {
		logger.info("---> update cart in impl..!");
		User user = userService.fetchUser(userId);
		double value;
		Cart cart = cartDao.fetchCart(user.getCart().getCartId());
		int cartId = user.getCart().getCartId();
		Product product = productService.fetchProduct(productId);
		if (!(product.getCart().getCartId() == cart.getCartId())) {
			logger.error("---> product does not belong to user..!");
			throw new ProductNotBelongs(ShoppingConstants.PRODUCT_NOT_BELONGS);
		}
		if (updateQuantity == 0) {
			value = product.getQuantity() * product.getPrice();
			cart.setCartValue(cart.getCartValue() - value);
			product.setCart(null);
			product.setQuantity(0);
			productService.updateProduct(product);
		} else {
			value = (double) product.getPrice() * updateQuantity;
			cart.setCartValue(cart.getCartValue() + (value));

			product.setQuantity(product.getQuantity() + (updateQuantity));
			if (product.getQuantity() == 0) {
				product.setCart(null);
			}
			if (product.getQuantity() < 0) {
				logger.error("---> Product Quantity Should not be negative ...!");
				throw new QuantityNotInLimitException(ShoppingConstants.PRODUCT_QUANTITY_NOT_IN_RANGE);
			}
			productService.updateProduct(product);
		}
		if (cart.getCartValue() == 0) {
			user.setCart(null);
			userService.updateUser(user);
			cart.setProductList(null);
			cartDao.deleteCart(cartId);
		}
		logger.info("---> Cart updated Succesfully...!");
		shop.setResult("Cart Updated SuccessFully...!");
		return shop;
	}

}
