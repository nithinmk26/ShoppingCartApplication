/**
 * 
 */
package com.mindtree.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.cart.entity.Cart;
import com.mindtree.cart.entity.Product;

/**
 * @author M1056182
 *
 */
@Repository
public interface productReposiroty extends JpaRepository<Product, Integer>{

	Product findByProductName(String productName);

	boolean existsByProductName(String productName);

	List<Product> findAllByCart(Cart cart);

   
}
