package com.cuisine_mart.order.dao.IDaoContract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cuisine_mart.order.domain.Food;

@Repository
public interface IFoodDao extends JpaRepository<Food, Long> {
	@Query("SELECT f FROM Food f WHERE f.name like CONCAT('%',:name,'%')")
	public List<Food> findFoodByName(@Param ("name")String name);
	@Query("SELECT distinct f FROM Food f Where f.type=:type ")
	public List<Food> findFoodByType(@Param ("type")String type);
	@Query("SELECT distinct f From Food f WHERE f.id = :FoodId")
	public Food findFoodById(@Param("FoodId") Long id);
}
