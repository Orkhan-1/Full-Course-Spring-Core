package com.orkhangasanov.configdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.orkhangasanov")
@PropertySource("classpath:application.properties")
public class AppConfigFile {
}