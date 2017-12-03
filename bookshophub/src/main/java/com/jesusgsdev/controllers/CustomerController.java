package com.jesusgsdev.controllers;

import com.jesusgsdev.dtos.CustomerDTO;
import com.jesusgsdev.facades.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerFacade customerFacade;

    @PostMapping
    public CustomerDTO addBook(@RequestBody @Valid CustomerDTO customerDTO) {
        return customerFacade.addCustomer(customerDTO);
    }

}
