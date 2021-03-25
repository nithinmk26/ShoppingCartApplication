/**
 * 
 */
package com.digital.cart.dao;

import java.util.List;

import com.digital.cart.entity.Appearal;
import com.digital.cart.entity.Books;
import com.digital.cart.entity.Cart;
import com.digital.cart.entity.Product;

/**
 * @author M1056182
 *
 */
public interface ProductDao {

	Product searchById(int productId);

	boolean checkProduct(int productId);

	boolean checkProduct(String productName);

	Product searchByProductName(String productName);

	List<Books> getAllBooks();

	List<Appearal> getAllAppearal();

	void updateProduct(Product product);

	static List<Product> listCartItems(Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}




}
