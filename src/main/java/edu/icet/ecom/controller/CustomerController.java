package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Customer;
import edu.icet.ecom.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/search-customerById/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Customer searchCustomer(@PathVariable Integer id) {
        return service.searchCustomer(id);
    }

    @PutMapping("/update-customer")
    public void updateCustomer(@RequestBody Customer customer) {
        service.updateCustomer(customer);
    }

    @DeleteMapping("/delete-customer/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        service.deleteCustomer(id);
    }

    @GetMapping("/get-all-customers")
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

}
