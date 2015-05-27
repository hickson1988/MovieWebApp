/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devel.moviesapp.repositories;

import com.devel.moviesapp.entities.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Michael Hickson
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m WHERE m.name = ?1")
    Movie findByName(String lastName);
    
    @Query("SELECT m FROM Movie m WHERE m.movieId = ?1")
    Movie findById(int id);
    
    @Query("SELECT m FROM Movie m WHERE m.rating >= 9")
    List<Movie> findTopMovies();

}
