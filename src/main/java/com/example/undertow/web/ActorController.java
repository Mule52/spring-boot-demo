package com.example.undertow.web;

import java.util.concurrent.Callable;
import com.example.persistence.jpa.dao.ActorDao;
import com.example.persistence.jpa.entity.ActorEntity;
import com.example.undertow.service.DateTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class ActorController {

    @Autowired
    private ActorDao actorDao;

    @Autowired
    private DateTimeService timeService;

    // The @ResponseBody annotation tells Spring MVC not to render a model into a view,
    // but rather to write the returned object into the response body. It does this by
    // using one of Spring’s message converters. This is helpful to turn objects into JSON output.

    @RequestMapping(value="/actor", method= RequestMethod.GET)
    public @ResponseBody Iterable<ActorEntity> getActors() {
        return actorDao.findAll();
    }

    @RequestMapping(value="/actor/{page}/{size}", method= RequestMethod.GET)
    public @ResponseBody Iterable<ActorEntity> getActors(@PathVariable Short page, @PathVariable Short size) {
        return actorDao.findAll(new PageRequest(page, size));
        // http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
    }

    @RequestMapping(value="/actor/{id}", method= RequestMethod.GET)
    public @ResponseBody Callable<ActorEntity> getActorByIdAsync(@PathVariable Short id) {
        return () -> actorDao.findOne(id);
    }

    @RequestMapping(value="/actor", method=RequestMethod.PUT)
    public @ResponseBody ActorEntity updateActorAsync(@RequestBody ActorEntity actorEntity) {
        actorEntity.setLastUpdate(timeService.getCurrentTimestamp());
        return actorDao.save(actorEntity);
    }

    @RequestMapping(value="/actor", method=RequestMethod.POST)
    public @ResponseBody ActorEntity createActorAsync(@RequestBody ActorEntity actorEntity) {
        actorEntity.setLastUpdate(timeService.getCurrentTimestamp());
        return actorDao.save(actorEntity);
    }

    @RequestMapping(value="/actor/{id}", method= RequestMethod.DELETE)
    public @ResponseBody Callable<Short> deleteActorByIdAsync(@PathVariable Short id) {
        return () -> actorDao.deleteByActorId(id);
    }
}