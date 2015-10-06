package com.example.undertow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleUndertowApplication {

    public static void main(String[] args) throws Exception {
        System.out.println("*** SampleUndertowApplication ***");
        SpringApplication.run(SampleUndertowApplication.class, args);
    }

}
