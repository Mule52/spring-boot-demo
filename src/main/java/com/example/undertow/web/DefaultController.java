package com.example.undertow.web;

import com.example.undertow.service.DateTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.Callable;

@Controller
public class DefaultController {

    @Autowired
    private DateTimeService timeService;

    // Default mapping, load our client framework via the index.html
    @RequestMapping("/")
    public String index() {
        System.out.println("/ index called");
        return "index.html";
    }

    // Simple async example - here for reference
    @RequestMapping("/async")
    public Callable<String> helloWorldAsync() {
        return new Callable<String>() {

            @Override
            public String call() throws Exception {
                return "async: "
                        + DefaultController.this.timeService.getCurrentTimestamp();
            }

        };
    }

}
