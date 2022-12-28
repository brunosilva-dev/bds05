package com.devsuperior.movieflix.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieMinDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {

    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<Page<MovieMinDTO>> pagedMovies(
            @PageableDefault(size = 10, page = 0, sort = "title", direction = Sort.Direction.ASC) Pageable pageable,
            @RequestParam(value = "genreId", defaultValue = "0") Long genreId) {

        return ResponseEntity.ok(service.pagedMovies(genreId, pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(value = "/{id}/reviews")
    public ResponseEntity<List<ReviewDTO>> findReviewsByMovie(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findReviewsByMovie(id));
    }
}
