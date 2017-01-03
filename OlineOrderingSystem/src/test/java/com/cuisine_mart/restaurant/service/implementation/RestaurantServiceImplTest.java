package com.cuisine_mart.restaurant.service.implementation;

import com.cuisine_mart.order.domain.Food;
import com.cuisine_mart.order.domain.FoodType;
import com.cuisine_mart.restaurant.domain.CuisineCategory;
import com.cuisine_mart.restaurant.domain.Menu;
import com.cuisine_mart.restaurant.domain.Restaurant;
import com.cuisine_mart.restaurant.service.IServiceContract.IRestaurantService;
import com.cuisine_mart.user.domain.Address;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Rajiv on 8/28/2016.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@Transactional
public class RestaurantServiceImplTest {
    @Autowired
    IRestaurantService restaurantService;

    Restaurant restaurant;
    Restaurant restaurant1;
    Food food1;
    Food food2;
    Food food3;
    Food food4;

    @Before
    public void setup(){
        restaurant = new Restaurant("f-one","This is a nice restaurant which serves variety of foods",
                null,initAddress1(),initCuisine1(),initMenu1(),"test@gmail.com");

        restaurant1 = new Restaurant("f-two","Best restaurant in the town",
                null,initAddress2(),initCuisine2(),initMenu2(),"test@gmail.com");
    }

    public List<Address> initAddress1(){
        Address address = new Address();
        address.setState("IA");
        address.setStreet("1000 N, 4th Street");
        address.setZip(52557);
        address.setCity("Fairfield");
        return Arrays.asList(address);
    }

    public List<Address> initAddress2(){
        Address address = new Address();
        address.setState("IA");
        address.setStreet("1000 N, 3rd Street");
        address.setZip(52557);
        address.setCity("Fairfield");
        return Arrays.asList(address);
    }

    public List<Food> initFood1(){
        food1 = new Food("AAA Pepper Pizza", FoodType.Pizza,"AAA Pizza with pepper",null,20);
        return Arrays.asList(food1);
    }

    public List<Food> initFood2(){
        food2 = new Food("BBB Pepper Pizza", FoodType.Pizza,"BBB Pizza with pepper",null,20);
        return Arrays.asList(food2);
    }

    public List<Food> initFood3(){
        food2 = new Food("CCC Pepper Pizza", FoodType.Pizza,"CCCC Pizza with pepper",null,20);
        return Arrays.asList(food3);
    }

    public List<Food> initFood4(){
        food2 = new Food("DDD Pepper Pizza", FoodType.Pizza,"DDDD Pizza with pepper",null,20);
        return Arrays.asList(food4);
    }

    public CuisineCategory initCuisine1(){
        CuisineCategory cuisineCategory = new CuisineCategory("Italian","italian cuisine",null);
        return cuisineCategory;
    }

    public CuisineCategory initCuisine2(){
        CuisineCategory cuisineCategory = new CuisineCategory("Chinese","chinese cuisine",null);
        return cuisineCategory;
    }

    public List<Menu> initMenu1(){
        Menu menu1 = new Menu("Menu third","this is third menu",null,initFood1(),restaurant);
        Menu menu2 = new Menu("Menu third","this is third menu",null,initFood2(),restaurant);
        return Arrays.asList(menu1,menu2);
    }

    public List<Menu> initMenu2(){
        Menu menu1 = new Menu("Menu third","this is third menu",null,initFood1(),restaurant1);
        Menu menu2 = new Menu("Menu third","this is third menu",null,initFood2(),restaurant1);
        return Arrays.asList(menu1,menu2);
    }

    @Test
    public void testSave() throws Exception {
        restaurantService.save(restaurant);
        restaurantService.save(restaurant1);
        Assert.assertEquals("f-one",restaurantService.get(Long.parseLong("1")).getName());
        Assert.assertEquals("Chinese",restaurantService.get(Long.parseLong("2")).getCuisineCategory().getName());
    }

    @Test
    public void testDelete() throws Exception {
        restaurantService.save(restaurant);
        restaurantService.save(restaurant1);
        restaurantService.delete(Long.parseLong("2"));
        Assert.assertEquals(null,restaurantService.get(Long.parseLong("2")));
    }
}