/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devel.moviesapp.services;

import com.devel.moviesapp.entities.Movie;

/**
 *
 * @author Michael Hickson
 */
public interface CommentService {
    
    public void addComment(String comment, Movie movie);
}
