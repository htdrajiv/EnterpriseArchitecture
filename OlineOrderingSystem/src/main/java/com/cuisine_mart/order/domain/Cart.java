
package com.cuisine_mart.order.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 *
 * @author Eyuel Taddese
 */
public class Cart {

    private String cartId;
    private Map<Long, CartItem> cartItems;
    private Double grandTotal;
    private int totalItems=0;

    public Cart() {
        cartItems = new HashMap<>();
        grandTotal = new Double(0);
        totalItems = 0;
    }

    public Cart(String cartId) {
        this();
        this.cartId = cartId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Map<Long, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Long, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Double getGrandTotal() {
        return grandTotal;
    }

    public void addCartItem(CartItem item) {
        Long foodId = item.getFood().getId();

        if (cartItems.containsKey(foodId)) {
            CartItem existingCartItem = cartItems.get(foodId);
            existingCartItem.setQuantity(existingCartItem.getQuantity()
                    + item.getQuantity());
        }else{
            cartItems.put(foodId, item);
        }
        updateGrandTotal();
    }
    
    public void removeCartItem(CartItem item){
        Long foodId = item.getFood().getId();
        cartItems.remove(foodId);
        updateGrandTotal();
    }
    
    public void updateGrandTotal(){
        grandTotal = new Double(0);
        
        for(CartItem item: cartItems.values()){
            grandTotal = grandTotal + item.getTotalPrice();
            ++totalItems;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.cartId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cart other = (Cart) obj;
        if (!Objects.equals(this.cartId, other.cartId)) {
            return false;
        }
        return true;
    }
    
    
}
