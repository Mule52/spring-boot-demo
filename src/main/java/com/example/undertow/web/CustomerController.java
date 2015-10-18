package com.example.undertow.web;

import java.util.concurrent.Callable;
import com.example.persistence.jpa.dao.CustomerDao;
import com.example.persistence.jpa.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping(value="/customer", method= RequestMethod.GET)
    public @ResponseBody Iterable<CustomerEntity> getCusomters() {
        return customerDao.findAll();
    }

    @RequestMapping(value="/customer/{id}", method= RequestMethod.GET)
    public @ResponseBody Callable<CustomerEntity> getCusomterByIdAsync(@PathVariable Short id) {
        //return () -> customerDao.findOne(id);
        return () -> {
            // multiline lambda looks like this () -> {};
            return customerDao.findOne(id);
        };
    }

}