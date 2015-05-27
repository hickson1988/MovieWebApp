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
public interface MovieService {

    public void addMovie(String name, String actors, int rating);

    public void updateMovie(int id, String name, String actors, int rating);
    
    public void removeMovie(Movie movie);
}
