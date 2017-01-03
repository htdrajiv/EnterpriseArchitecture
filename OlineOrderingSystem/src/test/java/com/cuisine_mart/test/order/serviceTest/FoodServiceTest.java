package com.cuisine_mart.test.order.serviceTest;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cuisine_mart.order.domain.Food;
import com.cuisine_mart.order.domain.FoodType;
import com.cuisine_mart.order.exception.FoodNotFound;
import com.cuisine_mart.order.service.IServiceContract.IFoodService;
import com.cuisine_mart.restaurant.domain.Menu;
import com.cuisine_mart.restaurant.domain.Restaurant;
import com.fasterxml.jackson.core.format.InputAccessor.Std;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = com.cuisine_mart.configuration.AppConfig.class)
//@Transactional
public class FoodServiceTest {
	@Autowired
	IFoodService foodService;
	

	@Test
	public void testCreate() {
		Food sample = new Food("Tuna Pizza", FoodType.Pizza, "Hot Pizza", null, 10.2);
		Food addedFood = foodService.create(sample);
		Assert.assertEquals("Tuna Pizza", addedFood.getName());
	}

	@Test
	public void testUpdate() {
		Food sample = new Food("Tuna Pizza",FoodType.Vegiterian,"Vegiterian",null, 25);
		sample.setId((long)8);
		try {
			foodService.update(sample);
			Food result = foodService.findById((long)8);
			Assert.assertEquals(result, sample);
		} catch (FoodNotFound e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		Food foodToDelete = new Food();
		foodToDelete.setId((long)10);
		try {
			foodService.delete(foodToDelete);
		} catch (FoodNotFound e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Food retrivedFood = foodService.findById((long)7);
			Assert.assertNull(retrivedFood);
		} catch (FoodNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//foodService.delete(food);
	}
	
	@Test
	public void testDeleteById() {
		try {
			foodService.delete((long) 6);
			Food food = foodService.findById((long) 6);
			Assert.assertNull(food);
		} catch (FoodNotFound e) {
			System.out.println("Food Not Found");
		}
	}
	
	@Test
	public void testFindByName() {
		try {
			List<Food> result = foodService.findByName("Tuna Pizza");
			for(Food f : result) {
				System.out.println(f.getName());
			}
			Assert.assertNotNull(result);
		} catch (FoodNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFindByType() {
		try {
			List<Food> result = foodService.findByType("Pizza");
			Assert.assertNotNull(result);
		} catch (FoodNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFindAll() {
		List<Food> allFoods = foodService.findAll();
		Assert.assertNotNull(allFoods);
	}

	@Test
	public void testFindById() {
		try {
			Food food = foodService.findById((long) 4);
			Assert.assertNotNull(food);
		} catch (FoodNotFound e) {
			Assert.fail("Food Not Found");
		}
	}

}
