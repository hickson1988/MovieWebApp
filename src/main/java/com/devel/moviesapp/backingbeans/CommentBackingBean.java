/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devel.moviesapp.backingbeans;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Size;

/**
 *
 * @author Michael Hickson
 */
@Named
@RequestScoped
public class CommentBackingBean implements Serializable{
    
    @Size(max = 45, message = "Number of characters must not be larger than 45.")
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
}
