package com.cuisine_mart.order.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cuisine_mart.order.domain.Cart;
import com.cuisine_mart.order.service.IServiceContract.ICartService;
import com.cuisine_mart.order.service.IServiceContract.IFoodService;
import com.cuisine_mart.restaurant.domain.Restaurant;
import com.cuisine_mart.restaurant.service.IServiceContract.IRestaurantService;

@Controller
public class homeController {
	@Autowired
	IFoodService foodService;
	
    @Autowired
    IRestaurantService restaurantService;
    
    @Autowired
    ICartService cartService;
	
	@RequestMapping(value="/",method= RequestMethod.GET)
	public String homePage(Model model) {
		return "redirect:/user/dashboard";
	}
	
	@RequestMapping(value="/user/dashboard", method= RequestMethod.GET)
	public String userDashBoard(ModelMap modelMap,HttpServletRequest request) {
        List<Restaurant> restaurants = restaurantService.findAll();

        modelMap.addAttribute("restaurants",restaurants);

		return "userDashBoard";
	}
	
	@RequestMapping(value="/payment", method= RequestMethod.GET)
	public String paymentPage(Model model) {
		return "paymentPage";
	}
}
