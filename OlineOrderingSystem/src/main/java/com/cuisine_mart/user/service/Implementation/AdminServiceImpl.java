package com.cuisine_mart.user.service.Implementation;

import com.cuisine_mart.beans.RestaurantInfoBean;
import com.cuisine_mart.order.domain.Food;
import com.cuisine_mart.order.domain.FoodType;
import com.cuisine_mart.order.exception.FoodNotFound;
import com.cuisine_mart.order.service.IServiceContract.IFoodService;
import com.cuisine_mart.restaurant.domain.CuisineCategory;
import com.cuisine_mart.restaurant.domain.Menu;
import com.cuisine_mart.restaurant.domain.Restaurant;
import com.cuisine_mart.restaurant.service.IServiceContract.ICuisineCategoryService;
import com.cuisine_mart.restaurant.service.IServiceContract.IMenuService;
import com.cuisine_mart.restaurant.service.IServiceContract.IRestaurantService;
import com.cuisine_mart.user.domain.Address;
import com.cuisine_mart.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sadiksha
 *
 */
@Service
public class AdminServiceImpl {

	@Autowired
	ICuisineCategoryService iCuisineCategoryService;

	@Autowired
	IRestaurantService iRestaurantService;

	@Autowired
	IMenuService menuService;

	@Autowired
	IFoodService foodService;

	public void createUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void saveRestaurant(RestaurantInfoBean restaurantInfoBean) {
		// TODO Auto-generated method stub
		Long restaurantId = (Long)restaurantInfoBean.getId();
		CuisineCategory cuisineCategory = iCuisineCategoryService.get(restaurantInfoBean.getCuisineId());
		Restaurant restaurant;
		Address address = null;
		if (restaurantId != null) {
			restaurant = iRestaurantService.get(restaurantId);
			restaurant = setRestaurantValues(restaurant, restaurantInfoBean, address, cuisineCategory);
            iRestaurantService.update(restaurant);
		} else {
			address = new Address(restaurantInfoBean.getStreet(), restaurantInfoBean.getCity(), restaurantInfoBean.getState(),
					restaurantInfoBean.getZip(), restaurantInfoBean.getPhoneNumber());
			restaurant = new Restaurant(restaurantInfoBean.getName(), restaurantInfoBean.getDescription(),
					restaurantInfoBean.getImage(), Arrays.asList(address), cuisineCategory,null, restaurantInfoBean.getEmail());
            iRestaurantService.save(restaurant);
		}
	}

	public void saveMenu(@ModelAttribute Menu menu,@RequestParam String restaurantId,@RequestParam String menuId) {
		// TODO Auto-generated method stub
        Menu menuToSave = null ;
        if(menuId!=""){
            menuToSave = menuService.get(Long.parseLong(menuId));
            menuToSave.setDescription(menu.getDescription());
            menuToSave.setName(menu.getName());
        }else{
            menuToSave = menu;
        }
        Restaurant restaurant = iRestaurantService.get(Long.parseLong(restaurantId));
        menuToSave.setRestaurant(restaurant);
        menuService.create(menuToSave);
	}

	public void saveFood(@ModelAttribute("food") Food food,
                         ModelMap modelMap,@RequestParam String menuId,
                         @RequestParam String foodId,@RequestParam String foodType) throws FoodNotFound {
		// TODO Auto-generated method stub
        Menu menu = menuService.get(Long.parseLong(menuId));
        FoodType foodType1 = null;
        for(FoodType f : FoodType.values()){
            if(f.toString().toLowerCase().equals(foodType.toString().toLowerCase())) {
                foodType1 = f;
            }
            if(foodType1!=null) break;
        }
        Food food1 = null;
        List<Food> foods = new ArrayList<>();
        if(foodId!=""){
            food1 = foodService.findById(Long.parseLong(foodId));
            food1.setDescription(food.getDescription());
            food1.setName(food.getName());
            food1.setPrice(food.getPrice());
            food1.setType(foodType1);
            foods.add(food1);
        }else{
            foods.add(food);
        }

        menu.setFood(foods);
//        foodService.update(food);
        menuService.update(menu);
	}

	public Restaurant setRestaurantValues(Restaurant restaurant,RestaurantInfoBean restaurantInfoBean,
                                          Address address,CuisineCategory cuisineCategory){
		restaurant.setName(restaurantInfoBean.getName());
		restaurant.setDescription(restaurantInfoBean.getDescription());
        restaurant.setEmail(restaurantInfoBean.getEmail());
		restaurant.setCuisineCategory(cuisineCategory);
		address = restaurant.getAddressList().get(0);
		address = setAddressValues(address,restaurantInfoBean);
		List<Address> addresses = new ArrayList<>();
		addresses.add(address);
		restaurant.setAddressList(addresses);
		return restaurant;
	}

	public Address setAddressValues(Address address,RestaurantInfoBean restaurantInfoBean){
		address.setCity(restaurantInfoBean.getCity());
		address.setState(restaurantInfoBean.getState());
		address.setStreet(restaurantInfoBean.getStreet());
		address.setZip(restaurantInfoBean.getZip());
		address.setPhoneNo(restaurantInfoBean.getPhoneNumber());
		return address;
	}

}
