/**
 * 
 */
package com.mindtree.cart.dao.daoimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.cart.dao.UserDao;
import com.mindtree.cart.entity.User;
import com.mindtree.cart.repository.UserRepository;

/**
 * @author M1056182
 *
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class UserDaoImpl implements UserDao{
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = false)
	public User registerUser(User user) {
		logger.info("--> Registering User");
		return userRepository.save(user);
	}

	@Override
	public boolean isPresent(int userId) {
		logger.info("--> Checking User is Present in Database...!");
		return userRepository.existsById(userId);
	}

	@Override
	public User fetchUser(int userId) {
		logger.info("--> Fetching User from Repository..!");
		return userRepository.findById(userId).get();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = false)
	public void createCart(User user) {
		logger.info("--> Saving user into repository..!");
		userRepository.saveAndFlush(user);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = false)
	public void updateUser(User user) {
		logger.info("--> Update and saving User into DB");
		userRepository.saveAndFlush(user);
	}

	

}
