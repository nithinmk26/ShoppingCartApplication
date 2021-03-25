/**
 * 
 */
package com.digital.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.cart.entity.Books;

/**
 * @author M1056182
 *
 */
@Repository
public interface BooksRepository extends JpaRepository<Books, String>{

}
