package com.cuisine_mart.restaurant.service.implementation;

import com.cuisine_mart.restaurant.dao.IDaoContract.ICuisineDao;
import com.cuisine_mart.restaurant.domain.CuisineCategory;
import com.cuisine_mart.restaurant.service.IServiceContract.ICuisineCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Service
public class CuisineCategoryServiceImpl implements ICuisineCategoryService {
    @Autowired
    ICuisineDao cuisineDao;

    @Override
    public CuisineCategory get(Long id) {
        return cuisineDao.findOne(id);
    }

    @Override
    @Transactional
    public List<CuisineCategory> findAll() {
        return cuisineDao.findAll();
    }

    @Override
    @Transactional
    public List<CuisineCategory> findAllByNameLike(String name) {
        return cuisineDao.findAllByNameLike(name);
    }

    @Override
    @Transactional
    public List<CuisineCategory> findAllByDescriptionLike(String description) {
        return cuisineDao.findAllByDescriptionLike(description);
    }

    @Override
    @Transactional
    public CuisineCategory save(CuisineCategory cuisineCategory) {
        return cuisineDao.save(cuisineCategory);
    }

    @Override
    public void delete(CuisineCategory cuisineCategory) {
        cuisineDao.delete(cuisineCategory);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        cuisineDao.delete(id);
    }

    @Override
    public CuisineCategory update(CuisineCategory cuisineCategory) {
        return save(cuisineCategory);
    }
}
