package com.cuisine_mart.user.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuisine_mart.user.dao.IDaoContract.IUserDAO;
import com.cuisine_mart.user.dao.IDaoContract.IUserRoleDao;
import com.cuisine_mart.user.domain.User;
import com.cuisine_mart.user.domain.UserRole;
import com.cuisine_mart.user.service.IServiceContract.IUserService;
/**
 * @author Sadiksha
 *
 */
@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	IUserDAO userDAO;
	
	@Autowired
	IUserRoleDao userRoleDao;
	
	@Override
	public User saveNewUser(User user) {
		return userDAO.save(user);
	}

	@Override
	public boolean authenticateUser(User user) {
		
		return true;
	}

	@Override
	public List<User> getAllUsers() {
		
		return userDAO.findAll();
	}
	
	@Override
	public User getUserByUsername(String username) {
		return userDAO.findByUsername(username);
	}

	@Override
	public User findUserByUserId(Long userId) {
		// TODO Auto-generated method stub
		return userDAO.findOne((Long) userId);
	}

	@Override
	public void deleteUser(int userId) {
		userDAO.delete((long)userId);
		
	}

	@Override
	public List<User> searchUserByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return userDAO.findAllUserByKeyword(keyword);
	}

	@Override
	public void signup(User user) {
		userDAO.save(user);
		
	}

	/* (non-Javadoc)
	 * @see com.cuisine_mart.user.service.IServiceContract.IUserService#verifyUserByEmail(java.lang.Long)
	 */
	@Override
	public String verifyUserByEmail(Long userId) {
		User user = userDAO.findOne(userId);
		user.setEnabled(true);
		userDAO.save(user);
		return user.getUsername();
	}

	/* (non-Javadoc)
	 * @see com.cuisine_mart.user.service.IServiceContract.IUserService#saveUserRole(com.cuisine_mart.user.domain.UserRole)
	 */
	@Override
	public void saveUserRole(UserRole userRole) {
		userRoleDao.save(userRole);
		
	}

	/* (non-Javadoc)
	 * @see com.cuisine_mart.user.service.IServiceContract.IUserService#updateNewUser(com.cuisine_mart.user.domain.User)
	 */
	@Override
	public User updateNewUser(User user) {
		return userDAO.save(user);
	}

}
