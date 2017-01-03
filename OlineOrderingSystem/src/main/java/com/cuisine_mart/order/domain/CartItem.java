
package com.cuisine_mart.order.domain;

import java.util.Objects;

/**
 *
 * @author Eyuel Taddese
 */
public class CartItem {
    private Food food;
    private int quantity;
    private Double totalPrice;

    public CartItem() {
    }

    public CartItem(Food food) {
        this.food = food;
        this.quantity = 1;
        this.totalPrice = food.getPrice();
    }

    public Food getFood() {
        return food;
    }

    public void setProduct(Food food) {
        this.food = food;
        this.updateTotalPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.updateTotalPrice();
    }

    public Double getTotalPrice() {
        return totalPrice;
    }
    
    private void updateTotalPrice(){
        totalPrice = this.food.getPrice()*this.quantity;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.food);
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
        final CartItem other = (CartItem) obj;
        return Objects.equals(this.food, other.food);
    }
    
    
    
}
