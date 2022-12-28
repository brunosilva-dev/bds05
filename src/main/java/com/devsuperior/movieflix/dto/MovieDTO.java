package com.devsuperior.movieflix.dto;

import java.io.Serializable;
import java.util.Objects;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

public class MovieDTO implements Serializable {

    private static final long serialVersionUID = 1L;
	private Long id;
    private String title;
    private String subTitle;
    private Integer year;
    private String imgUrl;
    private String synopsis;
    private GenreDTO genre;

    public MovieDTO() {
    }

    public MovieDTO(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.year = year;
        this.imgUrl = imgUrl;
        this.synopsis = synopsis;
    }

    public MovieDTO(Movie entity) {
        this(entity.getId(), entity.getTitle(), entity.getSubTitle(), entity.getYear(), entity.getImgUrl(), entity.getSynopsis());
    }

    public MovieDTO(Movie entity, Genre genre) {
        this(entity);
        this.genre = new GenreDTO(genre);
    }

    public GenreDTO getGenre() {
        return genre;
    }

    public void setGenre(GenreDTO genre) {
        this.genre = genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDTO movieDTO = (MovieDTO) o;
        return id.equals(movieDTO.id) && title.equals(movieDTO.title) && subTitle.equals(movieDTO.subTitle) && year.equals(movieDTO.year) && imgUrl.equals(movieDTO.imgUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, subTitle, year, imgUrl);
    }
}
