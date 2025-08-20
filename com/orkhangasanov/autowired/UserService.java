package com.orkhangasanov.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private NotificationService notificationService;

    @Autowired
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void register(String name) {
        System.out.println("Registering user: " + name);
        notificationService.send("Welcome " + name);
    }
}
