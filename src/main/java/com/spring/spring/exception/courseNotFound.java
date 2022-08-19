package com.spring.spring.exception;

public class courseNotFound extends RuntimeException {

    private static final long serialVersionUID = 5071646428281007896L;

    public courseNotFound(String message) {
        super(message);
    }
    
}

