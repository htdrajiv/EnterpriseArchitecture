package com.cuisine_mart.order.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cuisine_mart.order.domain.Cart;
import com.cuisine_mart.order.domain.CartItem;
import com.cuisine_mart.order.domain.Food;
import com.cuisine_mart.order.exception.FoodNotFound;
import com.cuisine_mart.order.service.IServiceContract.ICartService;
import com.cuisine_mart.order.service.IServiceContract.IFoodService;

@Controller
@RequestMapping(value="/rest/cart")
public class CartRestController {
	@Autowired
	private ICartService cartService;
	
	@Autowired
	private IFoodService foodService;
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Cart create(@RequestBody Cart cart) {
		return cartService.create(cart);
	}
	
	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public @ResponseBody Cart read(@PathVariable(value ="cartId") String cartId) {
		return cartService.read(cartId);
	}
	
    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "cartId") String cartId,
            @RequestBody Cart cart) {
        cartService.update(cartId, cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartId") String cartId) {
        cartService.delete(cartId);
    }
    
    @RequestMapping(value = "/add/{foodId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addIItem(@PathVariable Long foodId, HttpServletRequest request) {
        String sessionId = request.getSession(true).getId();
        System.out.println(sessionId);
        Cart cart = cartService.read(sessionId);
        if (cart == null) {
        	System.out.println("Cart is new Created");
            cart = cartService.create(new Cart(sessionId));
        }

        Food food = null;
		try {
			food = foodService.findById(foodId);
		} catch (FoodNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (food == null) {
            throw new IllegalArgumentException(String.format("Food with id (%) not found", foodId));
        }
        cart.addCartItem(new CartItem(food));
        cartService.update(sessionId, cart);
    }
    
    @RequestMapping(value = "/remove/{foodId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable Long foodId, HttpServletRequest request) {
        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);

        if (cart == null) {
            cartService.create(new Cart(sessionId));
        }

        Food food = null;
		try {
			food = foodService.findById(foodId);
		} catch (FoodNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (food == null) {
            throw new IllegalArgumentException(String.format("Food with id (%) not found", foodId));
        }

        cart.removeCartItem(new CartItem(food));
        cartService.update(sessionId, cart);
    }
    
}
