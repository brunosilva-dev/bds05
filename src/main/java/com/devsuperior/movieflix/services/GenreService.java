package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.repositories.GenreRepository;

@Service
public class GenreService {

    @Autowired
    private GenreRepository repository;

    @Transactional
    public List<GenreDTO> listAll() {
        return repository.findAll().stream().map(GenreDTO::new).collect(Collectors.toList());
    }
}