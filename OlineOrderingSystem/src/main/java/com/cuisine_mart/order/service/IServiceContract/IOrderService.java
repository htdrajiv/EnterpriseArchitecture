package com.cuisine_mart.order.service.IServiceContract;

import java.util.Date;
import java.util.List;


import com.cuisine_mart.order.domain.FoodOrder;
import com.cuisine_mart.order.exception.OrderNotFound;
import com.cuisine_mart.order.exception.UserNotFound;

public interface IOrderService {
	public FoodOrder create(FoodOrder order);
	public void update(FoodOrder order) throws OrderNotFound;
	public void delete(Long orderId) throws OrderNotFound;
	public void delete(FoodOrder order) throws OrderNotFound;
	public List<FoodOrder> findByDate(Date date) throws OrderNotFound;
	public List<FoodOrder> findAll();
	public FoodOrder findById(Long id) throws OrderNotFound;
	public List<FoodOrder> findOrderByUser(String userName) throws UserNotFound;
}
