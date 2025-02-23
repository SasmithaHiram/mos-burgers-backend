package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Customer;
import edu.icet.ecom.entity.CustomerEntity;
import edu.icet.ecom.repository.CustomerRepository;
import edu.icet.ecom.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService {
    final CustomerRepository repository;
    final ModelMapper mapper;

    @Override
    public void addCustomer(Customer customer) {
        repository.save(mapper.map(customer, CustomerEntity.class));

    }

    @Override
    public List<Customer> getAllCustomers() {
        List<CustomerEntity> customerEntityList = repository.findAll();

        ArrayList<Customer> customers = new ArrayList<>();
        customerEntityList.forEach(customerEntity -> {
            customers.add(mapper.map(customerEntity, Customer.class));
        });
        return customers;
    }

}
