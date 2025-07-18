package edu.icet.ecom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerNotFoundException.class)
    ResponseEntity<ErrorResponse> customerNotFoundException(CustomerNotFoundException exc) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exc.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.OK);
    }

    @ExceptionHandler(CustomerAlreadyFoundException.class)
    ResponseEntity<ErrorResponse> customerAlreadyFoundException(CustomerAlreadyFoundException exc) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exc.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.ALREADY_REPORTED);
    }
}
