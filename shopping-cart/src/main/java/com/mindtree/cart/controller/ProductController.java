/**
 * 
 */
package com.mindtree.cart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.cart.dto.ProductDto;
import com.mindtree.cart.dto.ShopResponse;
import com.mindtree.cart.exception.ShoppingException;
import com.mindtree.cart.service.ProductService;

/**
 * @author M1056182
 *
 */
@RestController
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/searchById/{productId}", method = RequestMethod.GET)
	public ResponseEntity<ShopResponse> searchById(@PathVariable int productId) throws ShoppingException{
		logger.info("--> Searching Product by Id..!");
		return new ResponseEntity<ShopResponse>(productService.searchById(productId),HttpStatus.OK);
	}  
	
	@RequestMapping(value = "/searchByName/{productName}", method = RequestMethod.GET)
	public ResponseEntity<ShopResponse> searchByName(@PathVariable String productName) throws ShoppingException{
		logger.info("--> Searching Product By Name..!");
		return new ResponseEntity<ShopResponse>(productService.searchByName(productName),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/searchByCategory/{category}", method = RequestMethod.GET)
	public ResponseEntity<List<ProductDto>> searchByCategory(@PathVariable String category) throws ShoppingException{
		logger.info("--> Searching Product By Category..!");
		return  new ResponseEntity<List<ProductDto>>(productService.searchByCategory(category),HttpStatus.OK);
	}
	

	
	

}
