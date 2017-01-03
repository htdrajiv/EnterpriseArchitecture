package com.cuisine_mart.user.domain;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 * @author Sadiksha
 *
 */
@Entity
public class Person {
	@Id @GeneratedValue
	private Long personId;
	private String fristName;
	private String lastName;
	private String email;
//	@OneToOne
//	@JoinColumn(name="User_Id")
	//private User user;
	
	
	
	/**
	 * @param fristName
	 * @param lastName
	 * @param email
	 * @param address
	 */
	public Person(String fristName, String lastName, String email, List<Address> address) {
		super();
		this.fristName = fristName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
	}
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Address> address;
	
	public Person(){}
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
