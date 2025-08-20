package com.orkhangasanov.beanlifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class DemoBean implements InitializingBean, DisposableBean {

    public DemoBean() {
        System.out.println("1. Bean Instantiated");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("3. Bean Initialized (InitializingBean)");
    }

    @Override
    public void destroy() {
        System.out.println("5. Bean Destroyed (DisposableBean)");
    }

    @PostConstruct
    public void customInit() {
        System.out.println("2. Custom Init with @PostConstruct");
    }

    @PreDestroy
    public void customDestroy() {
        System.out.println("4. Custom Destroy with @PreDestroy");
    }
}