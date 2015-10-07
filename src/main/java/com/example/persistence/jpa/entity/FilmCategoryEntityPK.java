package com.example.persistence.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by alex on 10/7/15.
 */
public class FilmCategoryEntityPK implements Serializable {
    private short filmId;
    private byte categoryId;

    @Column(name = "film_id")
    @Id
    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    @Column(name = "category_id")
    @Id
    public byte getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(byte categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmCategoryEntityPK that = (FilmCategoryEntityPK) o;

        if (filmId != that.filmId) return false;
        if (categoryId != that.categoryId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) filmId;
        result = 31 * result + (int) categoryId;
        return result;
    }
}
