package com.cuisine_mart.order.dao.IDaoContract;



import com.cuisine_mart.order.domain.Cart;


public interface ICartDao {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart updatedCart);
    void delete(String cartID);
}
