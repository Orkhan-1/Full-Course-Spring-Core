package com.orkhangasanov.basics;

import com.orkhangasanov.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
    public void saveCustomer(Customer customer) {
        System.out.println("Saving customer: " + customer.getName());
    }
}

