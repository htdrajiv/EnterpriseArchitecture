package com.cuisine_mart.restaurant.service.IServiceContract;

import com.cuisine_mart.restaurant.domain.Menu;
import com.cuisine_mart.restaurant.domain.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Service
public interface IMenuService {
    Menu get(Long id);
    List<Menu> findAll();
    List<Menu> findAllByRestaurant(Restaurant restaurant);
    List<Menu> findAllByNameLike(String name);
    List<Menu> findAllByDescriptionLike(String description);
    Menu findByFood(Long foodId);
    Menu create(Menu menu);
    Menu update(Menu menu);
    void delete(Menu menu);
    void delete(Long id);
}
