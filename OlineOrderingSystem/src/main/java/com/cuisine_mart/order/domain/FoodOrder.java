package com.cuisine_mart.order.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cuisine_mart.user.domain.Address;
import com.cuisine_mart.user.domain.User;

@Entity
@Table
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId",nullable=false)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetail = new ArrayList<>();
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn
	@NotNull
	private User user;
	@OneToOne
	@JoinColumn(name="addressId")
	private Address address;
	
	
	public FoodOrder() {
		super();
	}
	
	
	public FoodOrder(Date orderDate, List<OrderDetail> orderDetail, User user, Address address) {
		super();
		this.orderDate = orderDate;
		this.orderDetail = orderDetail;
		this.user = user;
		this.address = address;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", orderDetail=" + orderDetail + ", user=" + user
				+ ", address=" + address + "]";
	}
	
	
}
