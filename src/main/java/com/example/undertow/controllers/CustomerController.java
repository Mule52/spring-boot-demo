package com.example.undertow.controllers;

import java.util.concurrent.Callable;
import com.example.persistence.jpa.dao.CustomerDao;
import com.example.persistence.jpa.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping(value="/customer", method= RequestMethod.GET)
    public @ResponseBody Iterable<Customer> getCusomters() {
        return customerDao.findAll();
    }

    @RequestMapping(value="/customer/{page}/{size}", method= RequestMethod.GET)
    public @ResponseBody Iterable<Customer> getCustomers(@PathVariable Short page, @PathVariable Short size) {
        return customerDao.findAll(new PageRequest(page, size));
        // http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
    }

    @RequestMapping(value="/customer/{id}", method= RequestMethod.GET)
    public @ResponseBody Callable<Customer> getCusomterByIdAsync(@PathVariable Integer id) {
        //return () -> customerDao.findOne(id);
        return () -> {
            // multiline lambda looks like this () -> {};
            return customerDao.findOne(id);
        };
    }

}