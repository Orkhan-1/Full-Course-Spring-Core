package com.orkhangasanov;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringAppConfig {

    @Bean
    public CustomerRepository repo() {
        return new CustomerRepository();
    }

    @Bean
    public CustomerService service() {
        return new CustomerService(repo());
    }
}
