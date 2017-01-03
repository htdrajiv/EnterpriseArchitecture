package com.cuisine_mart.user.service.IServiceContract;

import org.springframework.stereotype.Service;

import com.cuisine_mart.restaurant.domain.Menu;
import com.cuisine_mart.restaurant.domain.Restaurant;
import com.cuisine_mart.user.domain.User;
/**
 * @author Sadiksha
 *
 */
@Service
public interface IAdminService {
	void createUser(User user);
	void addRestaurant(Restaurant restaurant);
	void addMenu(Menu menu);
	void addFood();
}
