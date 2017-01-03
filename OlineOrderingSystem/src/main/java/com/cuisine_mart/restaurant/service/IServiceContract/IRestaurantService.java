package com.cuisine_mart.restaurant.service.IServiceContract;

import com.cuisine_mart.restaurant.domain.CuisineCategory;
import com.cuisine_mart.restaurant.domain.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Service
public interface IRestaurantService {
    Restaurant get(Long id);
    List<Restaurant> findAllByCuisine(CuisineCategory cuisineCategory);
    List<Restaurant> findAllByNameLike(String name);
    List<Restaurant> findAllByDescriptionLike(String description);
    Restaurant findByLocation(Long addressId);
    List<Restaurant> findAllByNameOrDescriptionLike(String inputText);
    List<Restaurant> findAll();
    Restaurant save(Restaurant restaurant);
    Restaurant update(Restaurant restaurant);
    void delete(Restaurant restaurant);
    void delete(Long id);

}
