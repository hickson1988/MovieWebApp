/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devel.moviesapp.controllers;

import com.devel.moviesapp.backingbeans.CommentBackingBean;
import com.devel.moviesapp.backingbeans.MovieBackingBean;
import com.devel.moviesapp.backingbeans.PageFrom;
import com.devel.moviesapp.entities.Comment;
import com.devel.moviesapp.entities.Movie;
import com.devel.moviesapp.repositories.CommentRepository;
import com.devel.moviesapp.repositories.MovieRepository;
import com.devel.moviesapp.services.CommentService;
import com.devel.moviesapp.services.MovieService;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Michael Hickson
 */
@Named(value = "movieController")
@SessionScoped
public class MovieController implements Serializable {

    private Movie movie;
    @Inject
    private PageFrom pageFrom;
    @Inject
    private MovieRepository movieRepository;
    @Inject
    private CommentRepository commentRepository;
    @Inject
    private MovieService movieService;
    @Inject
    private CommentService commentService;
    @Inject
    private MovieBackingBean movieBackingBean;
    @Inject
    private CommentBackingBean commentBackingBean;

    public MovieController() {

    }

    public String pageFromAction() {
        return pageFrom.getPage() + "?faces-redirect=true&includeViewParams=true";
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> getTopMovies() {
        return movieRepository.findTopMovies();
    }

    public List<Comment> getComments() {
        return commentRepository.findByMovieId(movieBackingBean.getId());
    }

    public void addMovie() {
        movieService.addMovie(movieBackingBean.getName(), movieBackingBean.getActors(), movieBackingBean.getRating());
    }
    
    public void updateMovie() {
        movieService.updateMovie(movieBackingBean.getId(), movieBackingBean.getName(), movieBackingBean.getActors(), movieBackingBean.getRating());
    }

    public void deleteMovie() {
        movieService.removeMovie(movie);
    }

    public void addComment() {
        commentService.addComment(commentBackingBean.getComment(), movie);
    }

    public void loadMovie() {
        movie = movieRepository.findById(movieBackingBean.getId());
        movieBackingBean.setId(movie.getMovieId());
        movieBackingBean.setName(movie.getName());
        movieBackingBean.setActors(movie.getActors());
        movieBackingBean.setRating(movie.getRating());
    }

    public MovieBackingBean getMovieBackingBean() {
        return movieBackingBean;
    }

    public void setMovieBackingBean(MovieBackingBean movieBackingBean) {
        this.movieBackingBean = movieBackingBean;
    }

    public CommentBackingBean getCommentBackingBean() {
        return commentBackingBean;
    }

    public void setCommentBackingBean(CommentBackingBean commentBackingBean) {
        this.commentBackingBean = commentBackingBean;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public PageFrom getPageFrom() {
        return pageFrom;
    }

    public void setPageFrom(PageFrom pageFrom) {
        this.pageFrom = pageFrom;
    }

}
