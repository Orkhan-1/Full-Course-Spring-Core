package com.orkhangasanov;

public class CustomerService {
    private CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public void setRepo(CustomerRepository repo) {
        this.repo = repo;
    }

    public void registerCustomer(String name) {
        repo.saveCustomer(name);
    }
}
