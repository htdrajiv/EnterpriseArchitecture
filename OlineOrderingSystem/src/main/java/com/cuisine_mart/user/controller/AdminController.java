package com.cuisine_mart.user.controller;

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
import com.cuisine_mart.user.service.Implementation.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Multipart;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Rajiv on 8/29/2016.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ICuisineCategoryService iCuisineCategoryService;

    @Autowired
    IRestaurantService iRestaurantService;

    @Autowired
    IMenuService menuService;

    @Autowired
    IFoodService foodService;

    @Autowired
    AdminServiceImpl adminService;

    @RequestMapping("/dashboard")
    public String dashboard(ModelMap modelMap){
        List<Restaurant> restaurants = iRestaurantService.findAll();
        List<Menu> menus = menuService.findAll();
        List<Food> foods = foodService.findAll();
        modelMap.addAttribute("restaurants",restaurants);
        modelMap.addAttribute("menus",menus);
        modelMap.addAttribute("foods",foods);
        return "adminDashboard";
    }
    @RequestMapping("/restaurantDetail/{restaurantId}")
    public String restaurantDetail(@PathVariable Long restaurantId,ModelMap modelMap){
        Restaurant restaurant = iRestaurantService.get(restaurantId);
        modelMap.addAttribute("restaurant",restaurant);
        return "restaurantDetail";
    }

    @RequestMapping("/addRestaurant")
    public String addRestaurant(ModelMap modelMap){
        List<CuisineCategory> cuisineCategoryList = iCuisineCategoryService.findAll();
        modelMap.addAttribute("restaurantInfoBean", new RestaurantInfoBean());
        modelMap.addAttribute("cuisines", cuisineCategoryList);
        return "addRestaurant";
    }

    @RequestMapping(value = "/saveRestaurant", method = RequestMethod.POST)
    public String saveRestaurant(RedirectAttributes redirectAttributes,@ModelAttribute("restaurantInfoBean") RestaurantInfoBean restaurantInfoBean,
                                 BindingResult bindingResult,ModelMap modelMap,HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/admin/addRestaurant";
        }
        MultipartFile restaurentImage = restaurantInfoBean.getImageToUpload();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        
        if(restaurentImage != null && !restaurentImage.isEmpty()) {
        	try {
        		
        	} catch(Exception e) {
        		throw new RuntimeException("Restaurent Image saving failed",e);
        	}
        }
        adminService.saveRestaurant(restaurantInfoBean);
        return "redirect:/admin/dashboard";
    }

    @RequestMapping("/editRestaurant/{id}")
    public String editRestaurant(@PathVariable Long id,ModelMap modelMap){
        List<CuisineCategory> cuisineCategoryList = iCuisineCategoryService.findAll();
        Restaurant restaurant = iRestaurantService.get(id);
        Address address = restaurant.getAddressList().get(0);
        RestaurantInfoBean restaurantInfoBean = new RestaurantInfoBean(restaurant.getName(),restaurant.getDescription(),
                address.getStreet(),address.getCity(),address.getZip(),address.getState(),
                address.getPhoneNo(),restaurant.getId(),restaurant.getCuisineCategory().getId(),restaurant.getEmail());
        modelMap.addAttribute("restaurantInfoBean",restaurantInfoBean);
        modelMap.addAttribute("cuisines", cuisineCategoryList);
        return "addRestaurant";
    }

    @RequestMapping(value = "/deleteRestaurant/{id}", method = RequestMethod.GET)
    public String deleteRestaurant(@PathVariable Long id){
        iRestaurantService.delete(id);
        return "redirect:/admin/dashboard";
    }

    @RequestMapping("/addMenu")
    public String addMenu(ModelMap modelMap){
        List<Restaurant> restaurants = iRestaurantService.findAll();
        modelMap.addAttribute("restaurants",restaurants);
        modelMap.addAttribute("menu",new Menu());
        return "addMenu";
    }

    @RequestMapping("/saveMenu")
    public String saveMenu(RedirectAttributes redirectAttributes,@ModelAttribute Menu menu,
                           BindingResult bindingResult,@RequestParam String restaurantId,@RequestParam String menuId){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/admin/addMenu";
        }
        adminService.saveMenu(menu,restaurantId,menuId);
        return "redirect:/admin/dashboard";
    }

    @RequestMapping("/editMenu/{id}")
    public String editMenu(@PathVariable Long id, ModelMap modelMap){
        List<Restaurant> restaurants = iRestaurantService.findAll();
        Menu menu = menuService.get(id);
        modelMap.addAttribute("restaurants",restaurants);
        modelMap.addAttribute("menu",menu);
        return "addMenu";
    }

    @RequestMapping(value = "/deleteMenu/{id}", method = RequestMethod.GET)
    public String deleteMenu(@PathVariable Long id){
        menuService.delete(id);
        return "redirect:/admin/dashboard";
    }

    @RequestMapping("/addFood")
     public String addFood(ModelMap modelMap){
        List<Restaurant> restaurants = iRestaurantService.findAll();
        List<Menu> menus = menuService.findAll();
        modelMap.addAttribute("restaurants",restaurants);
        modelMap.addAttribute("foodTypes", FoodType.values());
        modelMap.addAttribute("menus",menus);
        modelMap.addAttribute("food",new Food());
        return "addFood";
    }

    @RequestMapping("/saveFood")
    public String saveFood(RedirectAttributes redirectAttributes,@ModelAttribute("food") Food food,
                           BindingResult bindingResult,ModelMap modelMap,@RequestParam String menuId,
                           @RequestParam String foodId,@RequestParam String foodType) throws FoodNotFound {
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/admin/addFood";
        }
        adminService.saveFood(food,modelMap,menuId,foodId,foodType);
        return "redirect:/admin/dashboard";
    }


    @RequestMapping("/editFood/{id}")
    public String editFood(@PathVariable Long id,ModelMap modelMap) throws FoodNotFound {
        List<Restaurant> restaurants = iRestaurantService.findAll();
        List<Menu> menus = menuService.findAll();
        Food food = foodService.findById(id);
        Menu menu = menuService.findByFood(id);
        modelMap.addAttribute("restaurants",restaurants);
        modelMap.addAttribute("foodTypes", FoodType.values());
        modelMap.addAttribute("menus",menus);
        modelMap.addAttribute("food",food);
        modelMap.addAttribute("menu",menu);
        return "addFood";
    }

    @RequestMapping(value = "/deleteFood/{id}", method = RequestMethod.GET)
    public String deleteFood(@PathVariable Long id) throws FoodNotFound {
        Menu menu = menuService.findByFood(id);
        menu.removeFood(foodService.findById(id));
        foodService.delete(id);
        return "redirect:/admin/dashboard";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchRestaurants(@RequestParam String searchBox,ModelMap modelMap){
        List<Restaurant> restaurants = iRestaurantService.findAllByNameOrDescriptionLike(searchBox);
        List<Menu> menus = new ArrayList<>();
        List<Food> foods = new ArrayList<>();
        for(Restaurant restaurant:restaurants){
            menus.addAll(menuService.findAllByRestaurant(restaurant));
        }
        for(Menu menu : menus){
            foods.addAll(menu.getFood());
        }
        modelMap.addAttribute("menus",menus);
        modelMap.addAttribute("foods",foods);
        modelMap.addAttribute("restaurants",restaurants);
        modelMap.addAttribute("searchBoxText",searchBox);
        return "adminDashboard";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
    public String uploadImage(ModelMap model) {
        return "/users/user/fileupload";
    }

}
