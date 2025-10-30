package com.orkhangasanov.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class DemoBean implements InitializingBean, DisposableBean {

    private Connection connection;

    public DemoBean() {
        System.out.println("1. Bean Instantiated");
    }

    @PostConstruct
    public void customInit() {
        System.out.println("2. Custom Init with @PostConstruct — opening database connection");
        connection = new Connection();
        connection.open();
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("3. Bean Initialized (InitializingBean) — checking configuration");
        if (connection == null) {
            System.out.println("Warning: Connection not initialized properly!");
        }
    }

    @PreDestroy
    public void customDestroy() {
        System.out.println("4. Custom Destroy with @PreDestroy — cleaning up before shutdown");
        if (connection != null) connection.close();
    }

    @Override
    public void destroy() {
        System.out.println("5. Bean Destroyed (DisposableBean) — final cleanup done");
    }

    static class Connection {
        void open() { System.out.println("Connection opened"); }
        void close() { System.out.println("Connection closed"); }
    }
}
