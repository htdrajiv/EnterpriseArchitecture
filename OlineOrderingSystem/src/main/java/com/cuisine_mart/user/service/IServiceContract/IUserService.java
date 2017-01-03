package com.cuisine_mart.user.service.IServiceContract;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cuisine_mart.user.domain.User;
import com.cuisine_mart.user.domain.UserRole;
/**
 * @author Sadiksha
 *
 */
@Service
public interface IUserService {
	public User saveNewUser(User user);
	public User updateNewUser(User user);
	public void signup(User user); 
	boolean authenticateUser(User user);
	List<User> getAllUsers();
	User findUserByUserId(Long userId);
	void deleteUser(int userId);
	List<User> searchUserByKeyword(String keyword);
	public User getUserByUsername(String username);
	public String verifyUserByEmail(Long userId);
	public void saveUserRole(UserRole userRole);
}
