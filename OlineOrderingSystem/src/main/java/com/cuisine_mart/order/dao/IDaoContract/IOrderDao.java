package com.cuisine_mart.order.dao.IDaoContract;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cuisine_mart.order.domain.FoodOrder;

@Repository
public interface IOrderDao extends JpaRepository<FoodOrder, Long> {
	@Query("SELECT o FROM FoodOrder o WHERE o.orderDate=:orderDate")
	public List<FoodOrder> findOrderByDate(@Param("orderDate") Date date);
	@Query("SELECT o FROM FoodOrder o WHERE o.id=:orderId")
	public FoodOrder findOrderById(@Param("orderId") Long orderId);
	@Query("SELECT o FROM FoodOrder o WHERE o.user.username=:username")
	public List<FoodOrder> findUserOrder(@Param("username")String userId );
}
