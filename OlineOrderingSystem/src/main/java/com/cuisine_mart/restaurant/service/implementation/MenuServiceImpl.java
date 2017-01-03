package com.cuisine_mart.restaurant.service.implementation;

import com.cuisine_mart.restaurant.dao.IDaoContract.IMenuDao;
import com.cuisine_mart.restaurant.domain.Menu;
import com.cuisine_mart.restaurant.domain.Restaurant;
import com.cuisine_mart.restaurant.service.IServiceContract.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired
    IMenuDao iMenuDao;

    public void test(){
    }

    @Override
    public Menu get(Long id) {
        return iMenuDao.findOne(id);
    }

    @Override
    @Transactional
    public List<Menu> findAll() {
        return iMenuDao.findAll();
    }

    @Override
    @Transactional
    public List<Menu> findAllByRestaurant(Restaurant restaurant) {
        Long restaurantId = restaurant.getId();
        return iMenuDao.findAllByRestaurant(restaurantId);
    }

    @Override
    @Transactional
    public List<Menu> findAllByNameLike(String name) {
        return iMenuDao.findAllByNameLike(name);
    }

    @Override
    @Transactional
    public List<Menu> findAllByDescriptionLike(String description) {
        return iMenuDao.findAllByDescriptionLike(description);
    }

    @Override
    public Menu findByFood(Long foodId) {
        return iMenuDao.findByFood(foodId);
    }

    @Override
    @Transactional
    public Menu create(Menu menu) {
        return iMenuDao.save(menu);
    }

    @Override
    public Menu update(Menu menu) {
        return create(menu);
    }

    @Override
    @Transactional
    public void delete(Menu menu) {
        iMenuDao.delete(menu);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        iMenuDao.delete(id);
    }
}
