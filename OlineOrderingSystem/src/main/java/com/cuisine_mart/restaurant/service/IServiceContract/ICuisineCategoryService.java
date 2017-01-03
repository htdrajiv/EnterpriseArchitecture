package com.cuisine_mart.restaurant.service.IServiceContract;

import com.cuisine_mart.restaurant.domain.CuisineCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Service
public interface ICuisineCategoryService {
    CuisineCategory get(Long id);
    List<CuisineCategory> findAll();
    List<CuisineCategory> findAllByNameLike(String name);
    List<CuisineCategory> findAllByDescriptionLike(String description);
    CuisineCategory save(CuisineCategory cuisineCategory);
    void delete(CuisineCategory cuisineCategory);
    void delete(Long id);
    CuisineCategory update(CuisineCategory cuisineCategory);
}
