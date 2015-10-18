package com.example.undertow.web;

import com.example.persistence.jpa.dao.FilmDao;
import com.example.persistence.jpa.entity.FilmEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FilmController {

    @Autowired
    private FilmDao filmDao;

    @RequestMapping(value="/film", method= RequestMethod.GET)
    public @ResponseBody Iterable<FilmEntity> getFilms() {
        return filmDao.findAll();
    }

    @RequestMapping(value="/film/{id}", method= RequestMethod.GET)
    public @ResponseBody FilmEntity getFilmById(@PathVariable Short id) {
        return filmDao.findOne(id);
    }
}