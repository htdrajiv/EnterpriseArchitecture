package com.cuisine_mart.restaurant.domain;

import com.cuisine_mart.user.domain.Address;
import org.hibernate.validator.constraints.Email;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Entity
public class Restaurant {

    public Restaurant(){
        super();
    }

    public Restaurant(String name,String description,String image,List<Address> addressList,
                      CuisineCategory cuisineCategory,List<Menu> menus,String email){
        this.name = name;
        this.description = description;
        this.image = image;
        this.addressList = addressList;
        this.cuisineCategory = cuisineCategory;
        this.menus = menus;
        this.email = email;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long restaurantId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    private String image;

    @Email(message="Please provide a valid email address")
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addressList;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "category_id", nullable = false)
    private CuisineCategory cuisineCategory;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Menu> menus;

    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @Temporal(TemporalType.DATE)
    private Date lastUpdated;
    
    @Transient
    private MultipartFile restaurentImage;
    
    

    public MultipartFile getRestaurentImage() {
		return restaurentImage;
	}

	public void setRestaurentImage(MultipartFile restaurentImage) {
		this.restaurentImage = restaurentImage;
	}

	public Date getDateCreated() {
        return dateCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Long getId() {
        return restaurantId;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CuisineCategory getCuisineCategory() {
        return cuisineCategory;
    }

    public void setCuisineCategory(CuisineCategory cuisineCategory) {
        this.cuisineCategory = cuisineCategory;
    }

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
