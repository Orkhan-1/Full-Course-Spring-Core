package com.orkhangasanov;

public class CustomerService {
    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public void registerCustomer(String name) {
        repo.saveCustomer(name);
    }
}
