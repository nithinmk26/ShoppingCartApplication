/**
 * 
 */
package com.digital.cart.dao.daoimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.digital.cart.dao.ProductDao;
import com.digital.cart.entity.Appearal;
import com.digital.cart.entity.Books;
import com.digital.cart.entity.Cart;
import com.digital.cart.entity.Product;
import com.digital.cart.repository.AppearalRepository;
import com.digital.cart.repository.BooksRepository;
import com.digital.cart.repository.productReposiroty;

/**
 * @author M1056182
 *
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductDaoImpl implements ProductDao{
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);
	
	@Autowired
	private productReposiroty productRepository;
	
	@Autowired
	private BooksRepository booksRepository;
	
	@Autowired
	private AppearalRepository appearalRepository;

	@Override
	public Product searchById(int productId) {
		logger.info("-->SearchBy Id in impl");
		return productRepository.findById(productId).get();
	}

	@Override
	public boolean checkProduct(int productId) {
		logger.info("---> Check product presence By Id..!");
		return productRepository.existsById(productId);
	}
	
	@Override
	public boolean checkProduct(String productName) {
		logger.info("---> Checking Product presence by Name...!");
		return productRepository.existsByProductName(productName);
	}

	@Override
	public Product searchByProductName(String productName) {
		logger.info("---> fetching product by its Name..!");
		return productRepository.findByProductName(productName);
	}

	@Override
	public List<Books> getAllBooks() {
		logger.info("---> Fetching list of Books from repository..!");
		return booksRepository.findAll();
	}

	@Override
	public List<Appearal> getAllAppearal() {
		logger.info("---> Fetching list of Apperal from repository..!");
		return appearalRepository.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateProduct(Product product) {
		logger.info("---> Updating product in repository..!");
		productRepository.saveAndFlush(product);
	}

	public List<Product> listCartItems(Cart cart) {
		logger.info("---> Fetching a List of Products in a Cart..!");
		return productRepository.findAllByCart(cart);
	}


}
