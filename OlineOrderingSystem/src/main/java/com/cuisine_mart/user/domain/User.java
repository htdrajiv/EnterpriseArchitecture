package com.cuisine_mart.user.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.cuisine_mart.order.domain.FoodOrder;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Sadiksha
 *
 */
@Entity
@Table(name = "users")
public class User{
//	@Id
//	@GeneratedValue
//	private int userId;	
//	
	@Column(name="UserName",nullable=false)
	private String username;
	@Column(name="Password",nullable=false)
	private String password;
	@Column(name="Enabled",nullable=false)
	private boolean enabled;
	@Column(name="Email")
	private String email;
//	@OneToOne
//	@JoinColumn(name="Person_Id")
	@Column
	private Long person;
	private UserRole userRole;
	
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	public User() {
		super();
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public User(String username, String password,String email, boolean enabled, Long person) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.email = email;
		this.person = person;
	}

	
	@Id
	@Column(name = "username", unique = true, nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 60)
	public String getPassword() {
		return this.password;
	}
	
	public Long getPerson() {
		return person;
	}

	public void setPerson(Long person) {
		this.person = person;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@OneToOne(mappedBy = "user")
	public UserRole getUserRole() {
		return this.userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	

}