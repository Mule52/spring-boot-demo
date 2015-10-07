package com.example.undertow.web;

import java.util.List;
import java.util.concurrent.Callable;

import com.example.persistence.jpa.dao.ActorDao;
import com.example.persistence.jpa.entity.ActorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.undertow.service.HelloWorldService;


@RestController
public class SampleController {

    @Autowired
    private HelloWorldService helloWorldService;

    @Autowired
    private ActorDao actorDao;

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

    @RequestMapping("/actor")
    public String getActors() {
        //ActorDao dao = new com.example.persistence.jpa.dao.ActorDao();
        ActorEntity actor = new ActorEntity();
        actor.setLastName("Mueller");
        Iterable<ActorEntity> actors = actorDao.findAll();

        Iterable<ActorEntity> xxx = actorDao.findByLastNameContaining("m");
        //List<ActorEntity> actors = dao.getAll();
        return "we should see actors here";
    }

}