package com.orkhangasanov;

public class CustomerService {

    private CustomerRepository repo = new CustomerRepository(); // tightly coupled

    public void registerCustomer(String name) {
        repo.saveCustomer(name);
    }
}
