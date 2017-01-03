package com.cuisine_mart.restaurant.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Entity
public class CuisineCategory {
    public CuisineCategory(){
        super();
    }

    public CuisineCategory(String name,String description,String image){
        this.name = name;
        this.description = description;
        this.image = image;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cuisineId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    private String image;

    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @Temporal(TemporalType.DATE)
    private Date lastUpdated;

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return cuisineId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
