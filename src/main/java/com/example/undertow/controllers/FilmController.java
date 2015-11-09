package com.example.undertow.controllers;

import com.example.persistence.jpa.dao.FilmDao;
import com.example.persistence.jpa.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FilmController {

    @Autowired
    private FilmDao filmDao;

    @RequestMapping(value="/film", method= RequestMethod.GET)
    public @ResponseBody Iterable<Film> getFilms() {
        return filmDao.findAll();
    }

    @RequestMapping(value="/film/{id}", method= RequestMethod.GET)
    public @ResponseBody Film getFilmById(@PathVariable Short id) {
        return filmDao.findOne(id);
    }
}