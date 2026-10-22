package com.example.ecomerce.service;

import com.example.ecomerce.dto.CustomerRequestDto;
import com.example.ecomerce.model.Address;
import com.example.ecomerce.model.Customer;
import com.example.ecomerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;


    public void createCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = createCustomerFromDto(customerRequestDto);
        repository.save(customer);
    }

    private Customer createCustomerFromDto(CustomerRequestDto customerRequestDto) {
        Customer customer = new Customer(customerRequestDto.getFirstName(), customerRequestDto.getLastName(), customerRequestDto.getEmail(), customerRequestDto.getPhone());
        Address address = new Address();
        address.setStreet(customerRequestDto.getAddress().getStreet());
        address.setCity(customerRequestDto.getAddress().getCity());
        address.setZipCode(customerRequestDto.getAddress().getZipCode());
        customer.setAdress(address);
        return customer;
    }
}
