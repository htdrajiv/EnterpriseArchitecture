package com.cuisine_mart.restaurant.dao.IDaoContract;

import com.cuisine_mart.restaurant.domain.CuisineCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Repository
public interface ICuisineDao extends JpaRepository<CuisineCategory,Long>{
    @Query("from CuisineCategory c where c.name like CONCAT('%',:name,'%')")
    List<CuisineCategory> findAllByNameLike(@Param("name") String name);

    @Query("from CuisineCategory c where c.description like CONCAT('%',:description,'%')")
    List<CuisineCategory> findAllByDescriptionLike(@Param("description") String description);
}
