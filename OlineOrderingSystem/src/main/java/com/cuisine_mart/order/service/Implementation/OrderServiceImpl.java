package com.cuisine_mart.order.service.Implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cuisine_mart.order.dao.IDaoContract.IOrderDao;
import com.cuisine_mart.order.domain.FoodOrder;
import com.cuisine_mart.order.exception.OrderNotFound;
import com.cuisine_mart.order.exception.UserNotFound;
import com.cuisine_mart.order.service.IServiceContract.IOrderService;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private IOrderDao orderDao;

	@Override
	public FoodOrder create(FoodOrder order) {
		return orderDao.save(order);
	}

	@Override
	public void update(FoodOrder order) throws OrderNotFound {
		create(order);
	}

	@Override
	@Transactional
	public void delete(Long orderId) throws OrderNotFound {
		orderDao.delete(orderId);
		
	}

	@Override
	public void delete(FoodOrder order) throws OrderNotFound {
		orderDao.delete(order);
		
	}

	@Override
	public List<FoodOrder> findByDate(Date date) throws OrderNotFound {
		return orderDao.findOrderByDate(date);
	}
	
	@Override
	public List<FoodOrder> findAll() {
		return orderDao.findAll();
	}

	@Override
	public FoodOrder findById(Long id) throws OrderNotFound {
		return orderDao.findOrderById(id);
	}

	@Override
	public List<FoodOrder> findOrderByUser(String userName) throws UserNotFound {
		return orderDao.findUserOrder(userName);
	}

	
}
