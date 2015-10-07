package com.example.undertow.web;

import com.example.undertow.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
public class AnotherController {

//    @Autowired
//    private HelloWorldService helloWorldService;

    @RequestMapping("/another")
    public String getDefault() {
        return "this is the default message";
    }

//    @RequestMapping("/async")
//    public Callable<String> helloWorldAsync() {
//        return new Callable<String>() {
//
//            @Override
//            public String call() throws Exception {
//                return "async: "
//                        + SampleController.this.helloWorldService.getHelloMessage();
//            }
//
//        };
//
//    }

}
