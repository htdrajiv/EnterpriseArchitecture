package com.cuisine_mart.restaurant.dao.IDaoContract;

import com.cuisine_mart.restaurant.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Repository
public interface IMenuDao extends JpaRepository<Menu,Long> {
    @Query("from Menu m where m.restaurant.id = :restaurantId")
    List<Menu> findAllByRestaurant(@Param("restaurantId") Long restaurantId);

    @Query("from Menu c where c.name like CONCAT('%',:name,'%')")
    List<Menu> findAllByNameLike(@Param("name") String name);

    @Query("from Menu c where c.description like CONCAT('%',:description,'%')")
    List<Menu> findAllByDescriptionLike(@Param("description") String description);

    @Query("from Menu m join m.food f where f.id=:foodId")
    Menu findByFood(@Param("foodId") Long foodId);
}
