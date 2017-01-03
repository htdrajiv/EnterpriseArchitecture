package com.cuisine_mart.restaurant.dao.IDaoContract;

import com.cuisine_mart.restaurant.domain.CuisineCategory;
import com.cuisine_mart.restaurant.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Repository
public interface IRestaurantDao extends JpaRepository<Restaurant,Long> {
    @Query("from Restaurant r where r.cuisineCategory.id = :cuisineCategoryId")
    List<Restaurant> findAllByCuisine(@Param("cuisineCategoryId") Long cuisineCategoryId);

    @Query("from Restaurant c where c.name like CONCAT('%',:name,'%')")
    List<Restaurant> findAllByNameLike(@Param("name") String name);

    @Query("from Restaurant c where c.description like CONCAT('%',:description,'%')")
    List<Restaurant> findAllByDescriptionLike(@Param("description") String description);

    @Query("from Restaurant r join r.addressList al where al.addressId = :addressId")
    Restaurant findByLocation(@Param("addressId") Long addressId);

    @Query("from Restaurant r where r.description like CONCAT('%',:searchText,'%') or r.name like CONCAT('%',:searchText,'%')")
    List<Restaurant> findAllByDescriptionOrNameLike(@Param("searchText") String searchText);
}
