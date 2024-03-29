/**
 * 
 */
package com.digital.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.cart.entity.User;

/**
 * @author M1056182
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
