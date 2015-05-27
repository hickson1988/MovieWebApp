/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devel.moviesapp.repositories;

import com.devel.moviesapp.entities.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Michael Hickson
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    
    @Query("SELECT comm FROM Comment comm JOIN comm.movie m WHERE m.movieId = ?1")
    List<Comment> findByMovieId(int movieId);
}
