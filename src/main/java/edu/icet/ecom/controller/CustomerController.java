package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Customer;
import edu.icet.ecom.service.CustomerService;
import lombok.RequiredArgsConstructor;
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
    }

    @PutMapping("/update-customer")
    public void updateCustomer(@RequestBody Customer customer) {
        service.updateCustomer(customer);
    }
    @DeleteMapping("/delete-customer/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        service.deleteCustomer(id);
        System.out.println(id);
    }

    @GetMapping("/get-all-customers")
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

}
