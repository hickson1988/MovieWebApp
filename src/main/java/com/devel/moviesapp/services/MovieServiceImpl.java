/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devel.moviesapp.services;

import com.devel.moviesapp.entities.Movie;
import com.devel.moviesapp.repositories.MovieRepository;
import java.io.Serializable;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Michael Hickson
 */

public class MovieServiceImpl implements MovieService,Serializable {

    @Inject
    private MovieRepository movieRepository;

    @Transactional
    @Override
    public void addMovie(String name, String actors, int rating) {
        Movie movie=new Movie();
        movie.setName(name);
        movie.setActors(actors);
        movie.setRating(rating);
        movieRepository.save(movie);
    }
    
    @Transactional
    @Override
    public void updateMovie(int id, String name, String actors, int rating) {
        Movie movie=movieRepository.findById(id);
        movie.setName(name);
        movie.setActors(actors);
        movie.setRating(rating);
        movieRepository.save(movie);
    }

    @Transactional
    @Override
    public void removeMovie(Movie movie) {
        movieRepository.delete(movie);
    }

}
