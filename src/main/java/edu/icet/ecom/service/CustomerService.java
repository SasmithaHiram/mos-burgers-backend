package edu.icet.ecom.service;

import edu.icet.ecom.dto.Customer;
import edu.icet.ecom.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerService {
    void addCustomer(Customer customer);
}
