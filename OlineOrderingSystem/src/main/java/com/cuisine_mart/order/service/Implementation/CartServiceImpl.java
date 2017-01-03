package com.cuisine_mart.order.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuisine_mart.order.dao.IDaoContract.ICartDao;
import com.cuisine_mart.order.domain.Cart;
import com.cuisine_mart.order.service.IServiceContract.ICartService;

@Service
public class CartServiceImpl implements ICartService {
	@Autowired 
	ICartDao cartDao;

	@Override
	public Cart create(Cart cart) {
		return cartDao.create(cart);
	}

	@Override
	public Cart read(String cartId) {
		return cartDao.read(cartId);
	}

	@Override
	public void update(String cartId, Cart cart) {
		cartDao.update(cartId, cart);
		
	}

	@Override
	public void delete(String cartId) {
		cartDao.delete(cartId);
		
	}
	

}
