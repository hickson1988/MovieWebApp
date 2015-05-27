/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devel.moviesapp.backingbeans;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Michael Hickson
 */
@Named
@RequestScoped
public class MovieBackingBean implements Serializable{
    private int id;
    @NotNull(message = "Movie name is required.")
    @Size(min=1, max = 45, message = "Number of characters must be between 1 and 45.")
    private String name;
    @Max(value = 10, message = "Rating must be less than or equal to 10")
    private int rating;
    @Size(max = 45, message = "Number of characters must not be larger than 45.")
    private String actors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

}
