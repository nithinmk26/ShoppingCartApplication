/**
 * 
 */
package com.mindtree.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.cart.entity.Appearal;

/**
 * @author M1056182
 *
 */
@Repository
public interface AppearalRepository extends JpaRepository<Appearal, String>{

}