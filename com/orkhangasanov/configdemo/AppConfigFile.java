package com.orkhangasanov.configdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan("com.orkhangasanov")
@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource("classpath:application-${spring.profiles.active:dev}.properties")
})
public class AppConfigFile {
    // Loads both common and profile-specific properties
}