/**
 * 
 */
package com.mindtree.cart.service.serviceimpl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.cart.contants.ShoppingConstants;
import com.mindtree.cart.dao.UserDao;
import com.mindtree.cart.dto.ShopResponse;
import com.mindtree.cart.dto.UserDto;
import com.mindtree.cart.entity.User;
import com.mindtree.cart.exception.EmailInvalidException;
import com.mindtree.cart.exception.ShoppingException;
import com.mindtree.cart.exception.UserNameInvalidException;
import com.mindtree.cart.exception.UserNotFoundException;
import com.mindtree.cart.service.UserService;

/**
 * @author M1056182
 *
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	private ModelMapper model = new ModelMapper();
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public UserDto registerUser(UserDto userDto) throws ShoppingException {
		logger.info("---> Converting UserDto into User Entity Class..!");
		User user = model.map(userDto, User.class);
		logger.info("---> Converted to User Entity..!");
		if(validate(user)) {
		user = userDao.registerUser(user);
		logger.info("---> User Registered into DB..!");
		}
		return model.map(user, UserDto.class);
	}

	public boolean validate(User user) throws ShoppingException {
		logger.info("---> User Validation Begins...>!");
		if(!user.getName().matches(ShoppingConstants.USER_NAME)) {
			logger.error("---> User Name is INVALID....!");
			throw new UserNameInvalidException(ShoppingConstants.USER_NAME_INVALID);
		}
		if(!user.getEmail().matches(ShoppingConstants.EMAIL)) {
			logger.error("---> User Email Id is Invalid..!");
			throw new EmailInvalidException(ShoppingConstants.EMAIL_INVALID);
		}
		return true;
	}

	@Override
	public User fetchUser(int userId) throws ShoppingException {
		logger.info("--->User Fetching Starts..!");
		if(!userDao.isPresent(userId))
		{
			logger.info("---> User Not Found in Database..!");
			throw new UserNotFoundException(ShoppingConstants.USER_NOT_FOUND);
		}
		logger.info("-->User Found and Returned..!");
		return userDao.fetchUser(userId);
	}

	@Override
	public void createCart(User user) {
		logger.info("---> Creating new Cart for User...!");
		userDao.createCart(user);
	}

	@Override
	public void updateUser(User user) {
		logger.info("--->Creating a Cart for User..!");
		userDao.updateUser(user);
	}
	
}
