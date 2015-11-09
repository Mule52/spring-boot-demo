package com.example.undertow.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsrfTokenController {

    @RequestMapping(value="/api/csrf", method= RequestMethod.GET)
    public String getCsrfToken() {
        // This is a simple ajax call to return a response
        // with response headers containing csrf details.
        return null;
    }
}
