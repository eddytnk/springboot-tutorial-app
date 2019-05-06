package com.example.itemservice.exceptions;

/**
 * User: edward <br/>
 * Date: 5/5/19 5:41 PM <br/>
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}
