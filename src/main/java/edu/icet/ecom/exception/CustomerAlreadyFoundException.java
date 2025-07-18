package edu.icet.ecom.exception;

public class CustomerAlreadyFoundException extends RuntimeException {
    public CustomerAlreadyFoundException(String message) {
        super(message);
    }
}
