package com.example.undertow.web;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import com.example.persistence.jpa.dao.ActorDao;
import com.example.persistence.jpa.dao.CustomerDao;
import com.example.persistence.jpa.dao.FilmDao;
import com.example.persistence.jpa.entity.ActorEntity;
import com.example.persistence.jpa.entity.CustomerEntity;
import com.example.persistence.jpa.entity.FilmEntity;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.undertow.service.HelloWorldService;

import javax.websocket.server.PathParam;


@RestController
public class SampleController {

    @Autowired
    private HelloWorldService helloWorldService;

    @Autowired
    private ActorDao actorDao;

    @Autowired
    private FilmDao filmDao;

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping("/")
    public String defaultRequest() {
        return this.helloWorldService.getHelloMessage();
    }

    @RequestMapping("/async")
    public Callable<String> helloWorldAsync() {
        return new Callable<String>() {

            @Override
            public String call() throws Exception {
                return "async: "
                        + SampleController.this.helloWorldService.getHelloMessage();
            }

        };
    }

    @RequestMapping(value="/actor", method= RequestMethod.GET)
    public @ResponseBody Iterable<ActorEntity> getActors() {
        return actorDao.findAll();
    }

    @RequestMapping(value="/film", method= RequestMethod.GET)
    public @ResponseBody Iterable<FilmEntity> getFilms() {
        return filmDao.findAll();
    }

    @RequestMapping(value="/film/{id}", method= RequestMethod.GET)
    public @ResponseBody FilmEntity getFilmById(@PathVariable Short id) {
        return filmDao.findOne(id);
    }

    @RequestMapping(value="/customer", method= RequestMethod.GET)
    public @ResponseBody Iterable<CustomerEntity> getCusomters() {
        return customerDao.findAll();
    }

    @RequestMapping(value="/customer/{id}", method= RequestMethod.GET)
    public @ResponseBody Callable<CustomerEntity> getCusomtersByIdAsync(@PathVariable Short id) {
        //return () -> customerDao.findOne(id);
        return () -> {
            // multiline lambda looks like this () -> {};
            return customerDao.findOne(id);
        };
    }

}