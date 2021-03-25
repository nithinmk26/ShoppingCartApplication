/**
 * 
 */
package com.digital.cart.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.cart.contants.ShoppingConstants;
import com.digital.cart.dao.ProductDao;
import com.digital.cart.dto.ProductDto;
import com.digital.cart.dto.ShopResponse;
import com.digital.cart.entity.Appearal;
import com.digital.cart.entity.Books;
import com.digital.cart.entity.Product;
import com.digital.cart.exception.ProductNotFoundException;
import com.digital.cart.exception.ShoppingException;
import com.digital.cart.service.ProductService;

/**
 * @author M1056182
 *
 */
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	private ShopResponse search = new ShopResponse();
	
	private ModelMapper model = new ModelMapper();
	
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);


	@Override
	public ShopResponse searchById(int productId) throws ShoppingException {
		
		logger.info("-->Search by Id in impl..!");
		if(!productDao.checkProduct(productId)) {
			logger.error("---> Product Not Found Exception Found..!");
			throw new ProductNotFoundException(ShoppingConstants.PRODUCT_NOT_FOUND);
		}
		search.setResult("Search Result is");
		Product product = productDao.searchById(productId);
		logger.info("---> Converting Product entity to Product Entity...!");
		ProductDto productDto = model.map(product, ProductDto.class);
		search.setObject(productDto);
		logger.info("---> return product dto to the controller..!");
		return search;
	}

	@Override
	public ShopResponse searchByName(String productName) throws ShoppingException {
		logger.info("---> Search by Name in impl");
		if(!productDao.checkProduct(productName)) {
			logger.error("---> ProductNotFound Exception found..!");
			throw new ProductNotFoundException(ShoppingConstants.PRODUCT_NOT_FOUND);
		}
		search.setResult("Search Result is");
		Product product = productDao.searchByProductName(productName);
		logger.info("---> Converting Product entity to Product Entity...!");
		ProductDto productDto = model.map(product, ProductDto.class);
		search.setObject(productDto);
		logger.info("---> return product dto to the controller..!");
		return search;
	}

	@Override
	public List<ProductDto> searchByCategory(String category) throws ShoppingException {
		logger.info("--> Search by Category in impl...!");
		List<Books> listOfBooks = new ArrayList<Books>();
		List<Appearal> listOfAppearals = new ArrayList<Appearal>();
		List<ProductDto> objects = new ArrayList<ProductDto>();
		if(!(category.equalsIgnoreCase("Book") || category.equalsIgnoreCase("appearal"))) {
			logger.error("---> Category Not Found Exception Found..!");
			throw new ProductNotFoundException(ShoppingConstants.PRODUCT_NOT_FOUND);
		}
		if(category.equalsIgnoreCase("book")){
			logger.info("---> Seaching Book category...!");
			listOfBooks = productDao.getAllBooks();
			if(listOfBooks.size()==0) {
				logger.error("---> Book category Not Found..!");
				throw new ProductNotFoundException(ShoppingConstants.PRODUCT_NOT_FOUND);
			}
			listOfBooks.stream().forEach(book->objects.add(model.map(book, ProductDto.class)));
		}
		else if(category.equalsIgnoreCase("appearal")) {
			logger.info("---> Appearal Category Not Found..!");
			listOfAppearals = productDao.getAllAppearal();
			if(listOfAppearals.size()==0) {
				logger.error("---> Book Category Noyt Found...!");
				throw new ProductNotFoundException(ShoppingConstants.PRODUCT_NOT_FOUND);
			}
			listOfAppearals.stream().forEach(appearal->objects.add(model.map(appearal, ProductDto.class)));
		}
		logger.info("---> Return list of Products in Category");
		return objects;
	}

	@Override
	public Product fetchProduct(int productId) throws ShoppingException {
		logger.info("---> Fetching a Product From DB..!");
		if(!productDao.checkProduct(productId)) {
			logger.info("--> Product Not Found..!");
			throw new ProductNotFoundException(ShoppingConstants.PRODUCT_NOT_FOUND);
		}
		logger.info("--->Return Product by Id..!");
		return productDao.searchById(productId);
	}

	@Override
	public void updateProduct(Product product) {
		logger.info("---> Updating Product..!");
		productDao.updateProduct(product);
	}



}
