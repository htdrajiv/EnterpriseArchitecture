package com.cuisine_mart.restaurant.controller;

import com.cuisine_mart.restaurant.domain.Restaurant;
import com.cuisine_mart.restaurant.service.IServiceContract.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Rajiv on 8/27/2016.
 */
@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    IRestaurantService restaurantService;

    @RequestMapping(value = "/list")
    public String showRestaurants(ModelMap modelMap){
        List<Restaurant> restaurants = restaurantService.findAll();
        modelMap.addAttribute("restaurants",restaurants);
        return "restaurantList";
    }

    @RequestMapping(value = "/details/{restaurantId}", method = RequestMethod.GET)
    public String showDetail(@PathVariable Long restaurantId,ModelMap modelMap){
        Restaurant restaurant = restaurantService.get(restaurantId);
        modelMap.addAttribute("restaurant",restaurant);
        return "restaurantDetails";
    }
//
//    @RequestMapping(value = "/byLocation/{addressId}", method = RequestMethod.GET)
//    public String searchByLocation(@PathVariable Long addressId,ModelMap modelMap){
//        Restaurant restaurant = restaurantService.findByLocation(addressId);
//        modelMap.addAttribute("restaurant",restaurant);
//        return "restaurantDetails";
//    }
}
