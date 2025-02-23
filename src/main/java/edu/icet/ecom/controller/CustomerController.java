package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Customer;
import edu.icet.ecom.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@CrossOrigin


public class CustomerController {
    final CustomerService service;

    @PostMapping("/add-customer")
    public void addCustomer(@RequestBody Customer customer) {
        service.addCustomer(customer);
        System.out.println(customer);
    }

}
