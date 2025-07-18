package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Customer;
import edu.icet.ecom.entity.CustomerEntity;
import edu.icet.ecom.exception.CustomerAlreadyFoundException;
import edu.icet.ecom.exception.CustomerNotFoundException;
import edu.icet.ecom.repository.CustomerRepository;
import edu.icet.ecom.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    private final ModelMapper mapper;

    @Override
    public void addCustomer(Customer customer) throws CustomerAlreadyFoundException {
        Optional<CustomerEntity> existingCustomer = repository.findByEmail(customer.getEmail());

        if (existingCustomer.isPresent()) {
            throw new CustomerAlreadyFoundException("A customer already exists");
        }
        repository.save(mapper.map(customer, CustomerEntity.class));

    }

    @Override
    public Customer searchCustomerById(Integer id) {
        return mapper.map(repository.findById(id), Customer.class);
    }

    @Override
    public List<Customer> fineCustomerByName(String name) {
        List<CustomerEntity> byName = repository.findByName(name);

        List<Customer> customers = new ArrayList<>();

        byName.forEach(customerEntity -> {
            customers.add(mapper.map(customerEntity, Customer.class));
        });
        return customers;
    }

    @Override
    public void updateCustomer(Customer customer) {
        repository.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public void deleteCustomer(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Customer> getAllCustomers() throws CustomerNotFoundException {
        List<CustomerEntity> customerEntityList = repository.findAll();

        if (customerEntityList.isEmpty()) {
            throw new CustomerNotFoundException("Customers not found");
        }

        ArrayList<Customer> customers = new ArrayList<>();
        customerEntityList.forEach(customerEntity -> {
            customers.add(mapper.map(customerEntity, Customer.class));
        });
        return customers;
    }

}
