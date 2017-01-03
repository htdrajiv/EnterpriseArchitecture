/**
 * 
 */
package com.cuisine_mart.beans;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

/**
 * @author Sadiksha
 *
 */
@Component("UserInfoBean")
public class UserInfoBean {
	@NotNull
	private String firstName;
	private String lastName;
    @Size(min = 1,message = "{signup.email.error}")
    private String email;
    private BigInteger phoneNo;
    private String city;    
	private String street;
    
	private String state;
    private int zip;
    @Size(min = 1,message = "{signup.userName.empty.error}")
    private String userName;
    @NotNull(message = "{signup.password.empty.error}")
    @Size(min=1,message = "{signup.password.invalid.error}")
    private String password;
    
    /**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNo
	 * @param city
	 * @param street
	 * @param state
	 * @param zip
	 * @param userName
	 * @param password
	 */
    public UserInfoBean(){}
	public UserInfoBean(String firstName, String lastName, String email, BigInteger phoneNo, String city, String street,
			String state, int zip, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.city = city;
		this.street = street;
		this.state = state;
		this.zip = zip;
		this.userName = userName;
		this.password = password;
	}
    
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zip
	 */
	public int getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the phoneNo
	 */
	public BigInteger getPhoneNo() {
		return phoneNo;
	}
	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(BigInteger phoneNo) {
		this.phoneNo = phoneNo;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
}
