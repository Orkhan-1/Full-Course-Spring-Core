package com.orkhangasanov;

public class HelloWorld {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void sayHello() {
        System.out.println("Hello from Spring! Message = " + message);
    }
}
