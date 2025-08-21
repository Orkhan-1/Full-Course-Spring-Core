package com.orkhangasanov.service;

import com.orkhangasanov.dao.CustomerRepository;
import com.orkhangasanov.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository repo;
    private final NotificationService notifier;

    @Autowired
    public CustomerService(CustomerRepository repo, NotificationService notifier) {
        this.repo = repo;
        this.notifier = notifier;
    }

    public void registerCustomer(String name) {
        Customer customer = new Customer(name);
        repo.saveCustomer(customer);
        notifier.send("Welcome " + name);
    }
}
