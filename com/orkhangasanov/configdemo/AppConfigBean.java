package com.orkhangasanov.configdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class AppConfigBean {

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @Value("${app.support.email}")
    private String supportEmail;

    @Value("${database.url}")
    private String databaseUrl;

    @Value("${database.username}")
    private String databaseUsername;

    @Value("${server.port}")
    private int serverPort;

    @Value("${logging.level.com.orkhangasanov}")
    private String loggingLevel;
    
    public String getAppName() { return appName; }
    public String getAppVersion() { return appVersion; }
    public String getSupportEmail() { return supportEmail; }
    public String getDatabaseUrl() { return databaseUrl; }
    public String getDatabaseUsername() { return databaseUsername; }
    public int getServerPort() { return serverPort; }
    public String getLoggingLevel() { return loggingLevel; }

    public void displayConfig() {
        System.out.println("=== Application Configuration ===");
        System.out.println("App Name: " + appName);
        System.out.println("Version: " + appVersion);
        System.out.println("Support Email: " + supportEmail);
        System.out.println("Database URL: " + databaseUrl);
        System.out.println("Database User: " + databaseUsername);
        System.out.println("Server Port: " + serverPort);
        System.out.println("Logging Level: " + loggingLevel);
        System.out.println("=================================");
    }

}
