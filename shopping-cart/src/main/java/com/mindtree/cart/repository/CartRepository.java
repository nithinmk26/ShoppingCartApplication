/**
 * 
 */
package com.mindtree.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.cart.entity.Cart;

/**
 * @author M1056182
 *
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

}
