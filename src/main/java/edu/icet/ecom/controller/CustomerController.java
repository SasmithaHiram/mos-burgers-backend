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
    private final CustomerService service;

    @PostMapping("/add-customer")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer customer) {
        service.addCustomer(customer);
    }

    @GetMapping("/search-customerById/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Customer searchCustomer(@PathVariable Integer id) {
        return service.searchCustomerById(id);
    }

    @GetMapping("/search-customerByName/{name}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Customer> searchCustomerByName(@PathVariable String name) {
        return service.fineCustomerByName(name.trim().toLowerCase());
    }

    @PutMapping("/update-customer")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCustomer(@RequestBody Customer customer) {
        service.updateCustomer(customer);
    }

    @DeleteMapping("/delete-customer/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCustomer(@PathVariable Integer id) {
        service.deleteCustomer(id);
    }

    @GetMapping("/get-all-customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

}
