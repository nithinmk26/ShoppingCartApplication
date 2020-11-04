/**
 * 
 */
package com.mindtree.cart.service;

import java.util.List;

import com.mindtree.cart.dto.ProductDto;
import com.mindtree.cart.dto.ShopResponse;
import com.mindtree.cart.entity.Product;
import com.mindtree.cart.exception.ShoppingException;

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
