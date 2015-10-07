package com.example.persistence.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by alex on 10/7/15.
 */
public class FilmActorEntityPK implements Serializable {
    private short actorId;
    private short filmId;

    @Column(name = "actor_id")
    @Id
    public short getActorId() {
        return actorId;
    }

    public void setActorId(short actorId) {
        this.actorId = actorId;
    }

    @Column(name = "film_id")
    @Id
    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmActorEntityPK that = (FilmActorEntityPK) o;

        if (actorId != that.actorId) return false;
        if (filmId != that.filmId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) actorId;
        result = 31 * result + (int) filmId;
        return result;
    }
}
