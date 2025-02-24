package edu.icet.ecom.service;

import edu.icet.ecom.dto.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    List<Customer> getAllCustomers();
    void updateCustomer(Customer customer);
    void deleteCustomer(Integer id);

}
