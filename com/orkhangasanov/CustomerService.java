package com.orkhangasanov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
    }

    public void registerCustomer(String name) {
        repo.saveCustomer(name);
    }
}
