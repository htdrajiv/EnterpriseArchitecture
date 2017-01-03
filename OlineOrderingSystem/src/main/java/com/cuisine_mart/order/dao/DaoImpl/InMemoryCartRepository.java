package com.cuisine_mart.order.dao.DaoImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cuisine_mart.order.dao.IDaoContract.ICartDao;
import com.cuisine_mart.order.domain.Cart;

@Repository
public class InMemoryCartRepository implements ICartDao {
	
	private Map<String, Cart> carts= new HashMap<>();
	
	public InMemoryCartRepository() {

	}
	
	@Override
	public Cart create(Cart cart) {
		if(carts.containsKey(cart.getCartId())) {
			throw new IllegalArgumentException(String.format("Can not create a cart. A cart with the given id (%) already exist.", cart.getCartId()));
		}
		carts.put(cart.getCartId(), cart);
		return cart;
	}

	@Override
	public Cart read(String cartId) {
		return carts.get(cartId);
	}

	@Override
	public void update(String cartId, Cart updatedCart) {
		if(!carts.containsKey(cartId)) {
			throw new IllegalArgumentException(String.format("Cannot update the cart.The cart with the given id(%) does not exist", cartId));
		}
		carts.remove(cartId);
		carts.put(cartId, updatedCart);
	}

	@Override
	public void delete(String cartID) {
		if(!carts.containsKey(cartID)) {
            throw new IllegalArgumentException(String.format("Cannot delete cart. The cart with the given id (%) does not exist", cartID));
		}
		carts.remove(cartID);
	}

}
