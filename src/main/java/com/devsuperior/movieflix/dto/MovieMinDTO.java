package com.devsuperior.movieflix.dto;

import java.io.Serializable;
import java.util.Objects;

import com.devsuperior.movieflix.entities.Movie;

public class MovieMinDTO implements Serializable {

    private static final long serialVersionUID = 1L;
	private Long id;
    private String title;
    private String subTitle;
    private Integer year;
    private String imgUrl;

    public MovieMinDTO() {
    }

    public MovieMinDTO(Long id, String title, String subTitle, Integer year, String imgUrl) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.year = year;
        this.imgUrl = imgUrl;
    }

    public MovieMinDTO(Movie entity) {
        this(entity.getId(), entity.getTitle(), entity.getSubTitle(), entity.getYear(), entity.getImgUrl());
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
        MovieMinDTO that = (MovieMinDTO) o;
        return id.equals(that.id) && Objects.equals(title, that.title) && Objects.equals(subTitle, that.subTitle) && Objects.equals(year, that.year) && Objects.equals(imgUrl, that.imgUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, subTitle, year, imgUrl);
    }
}
