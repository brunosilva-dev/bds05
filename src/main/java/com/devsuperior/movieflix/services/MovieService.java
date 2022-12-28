package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieMinDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Transactional(readOnly = true)
    public Page<MovieMinDTO> pagedMovies(Long genreId, Pageable pageable) {
        Page<Movie> page;
        if (genreId > 0) {
            Genre genre = genreRepository.getReferenceById(genreId);
            page = repository.findByGenre(genre, pageable);
        } else {
            page = repository.findAll(pageable);
        }

        return page.map(MovieMinDTO::new);
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {
        Optional<Movie> optional = repository.findById(id);
        Movie entity = optional.orElseThrow(() -> new ResourceNotFoundException("Movie not found: " + id));
        return new MovieDTO(entity, entity.getGenre());
    }


    @Transactional(readOnly = true)
    public List<ReviewDTO> findReviewsByMovie(Long id) {
        Movie movie = repository.getOne(id);
        List<Review> reviews = reviewRepository.findByMovie(movie);
        return reviews.stream().map(ReviewDTO::new).collect(Collectors.toList());
    }
}
