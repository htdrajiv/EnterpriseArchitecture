package com.cuisine_mart.order.service.IServiceContract;

import com.cuisine_mart.order.domain.Cart;

public interface ICartService {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);
}
