/**
 * 
 */
package com.digital.cart.service;

import java.util.List;

import com.digital.cart.dto.ProductDto;
import com.digital.cart.dto.ShopResponse;
import com.digital.cart.entity.Product;
import com.digital.cart.exception.ShoppingException;

/**
 * @author M1056182
 *
 */
public interface ProductService {

	ShopResponse searchById(int productId) throws ShoppingException;

	ShopResponse searchByName(String productName) throws ShoppingException;

	List<ProductDto> searchByCategory(String category) throws ShoppingException;

	Product fetchProduct(int productId) throws ShoppingException;

	void updateProduct(Product product);


}
