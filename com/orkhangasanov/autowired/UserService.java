package com.orkhangasanov.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private NotificationService notificationService;

    public void register(String name) {
        System.out.println("Registering user: " + name);
        notificationService.send("Welcome " + name);
    }
}
