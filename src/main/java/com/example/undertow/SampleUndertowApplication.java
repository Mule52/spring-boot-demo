package com.example.undertow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.persistence.jpa.dao")
@EntityScan("com.example.persistence.jpa.entity")
@SpringBootApplication
public class SampleUndertowApplication {

    public static void main(String[] args) throws Exception {
        System.out.println("*** SampleUndertowApplication ***");
        SpringApplication.run(SampleUndertowApplication.class, args);
    }
}
