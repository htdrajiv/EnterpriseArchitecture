package com.cuisine_mart.order.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cuisine_mart.user.domain.Address;

@Entity
@Table
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="orderDetailId",nullable=false)
	private Long id;
/*	@ManyToOne
	@JoinColumn(name="orderId")
	private FoodOrder order;*/
	@OneToOne
	@JoinColumn(name="FoodId",referencedColumnName="FoodId")
	private Food food;
	private int qty;
/*	@OneToOne
	@JoinColumn(name="addressId")
	private Address address;*/
	
	public OrderDetail() {
		super();
	}
	 
	
	public OrderDetail(Food food, int qty) {
		super();
		this.food = food;
		this.qty = qty;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}
	

}
