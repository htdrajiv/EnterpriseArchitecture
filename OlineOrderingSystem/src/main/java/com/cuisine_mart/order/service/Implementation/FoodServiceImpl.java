package com.cuisine_mart.order.service.Implementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cuisine_mart.order.dao.IDaoContract.IFoodDao;
import com.cuisine_mart.order.domain.Food;
import com.cuisine_mart.order.exception.FoodNotFound;
import com.cuisine_mart.order.service.IServiceContract.IFoodService;

@Service
@Transactional
public class FoodServiceImpl implements IFoodService {
	@Autowired 
	IFoodDao foodDao;

	@Override
	@Transactional
	public Food create(Food food) {
		return foodDao.save(food);
	}

	@Override
	public void update(Food food) throws FoodNotFound {
		create(food);
	}

	@Override
	@Transactional
	public void delete(Long foodId) throws FoodNotFound {
		foodDao.delete(foodId);
		
	}

	@Override
	@Transactional
	public void delete(Food food) throws FoodNotFound {
		foodDao.delete(food);
		
	}
	
	@Override
	public List<Food> findByName(String name) throws FoodNotFound {
		return foodDao.findFoodByName(name);
	}

	@Override
	public List<Food> findByType(String type) throws FoodNotFound {
		return foodDao.findFoodByType(type);
	}

	@Override
	public List<Food> findAll() {
		return foodDao.findAll();
	}
	
	@Override
	public Food findById(Long id) throws FoodNotFound {
		return foodDao.findFoodById(id);
	}
	

}
