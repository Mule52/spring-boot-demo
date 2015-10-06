package com.example.undertow.web;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.undertow.service.HelloWorldService;

@RestController
public class SampleController {

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping("/")
    public String helloWorld() {
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

}