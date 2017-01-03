package com.cuisine_mart.restaurant.service.implementation;

import com.cuisine_mart.restaurant.dao.IDaoContract.IRestaurantDao;
import com.cuisine_mart.restaurant.domain.CuisineCategory;
import com.cuisine_mart.restaurant.domain.Restaurant;
import com.cuisine_mart.restaurant.service.IServiceContract.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Service
public class RestaurantServiceImpl implements IRestaurantService {
    @Autowired
    IRestaurantDao restaurantDao;

    @Override
    public Restaurant get(Long id) {
        return restaurantDao.findOne(id);
    }

    @Override
    @Transactional
    public List<Restaurant> findAllByCuisine(CuisineCategory cuisineCategory) {
        Long cuisineCategoryId = cuisineCategory.getId();
        return restaurantDao.findAllByCuisine(cuisineCategoryId);
    }

    @Override
    @Transactional
    public List<Restaurant> findAllByNameLike(String name) {
        return restaurantDao.findAllByNameLike(name);
    }

    @Override
    @Transactional
    public List<Restaurant> findAllByDescriptionLike(String description) {
        return restaurantDao.findAllByDescriptionLike(description);
    }

    @Override
    public Restaurant findByLocation(Long addressId) {
        return restaurantDao.findByLocation(addressId);
    }

    @Override
    public List<Restaurant> findAllByNameOrDescriptionLike(String inputText) {
        return restaurantDao.findAllByDescriptionOrNameLike(inputText);
    }

    @Override
    @Transactional
    public List<Restaurant> findAll() {
        return restaurantDao.findAll();
    }

    @Override
    @Transactional
    public Restaurant save(Restaurant restaurant){
        return restaurantDao.save(restaurant);
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        return restaurantDao.save(restaurant);
    }

    @Override
    @Transactional
    public void delete(Restaurant restaurant) {
        restaurantDao.delete(restaurant);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        restaurantDao.delete(id);
    }
}
