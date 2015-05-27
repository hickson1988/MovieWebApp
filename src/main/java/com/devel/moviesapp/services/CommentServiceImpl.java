/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devel.moviesapp.services;

import com.devel.moviesapp.entities.Comment;
import com.devel.moviesapp.entities.Movie;
import com.devel.moviesapp.repositories.CommentRepository;
import java.io.Serializable;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Michael Hickson
 */

public class CommentServiceImpl implements CommentService,Serializable{

    @Inject
    private CommentRepository commentRepository;

    @Transactional
    @Override
    public void addComment(String commentText, Movie movie) {
        Comment comment=new Comment();
        comment.setComment(commentText);
        comment.setMovie(movie);
        
        commentRepository.save(comment);
    }

}
