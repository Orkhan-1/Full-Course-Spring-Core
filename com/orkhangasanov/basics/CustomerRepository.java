package com.orkhangasanov.basics;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
    public void saveCustomer(String name) {
        System.out.println("Saving customer: " + name);
    }
}

