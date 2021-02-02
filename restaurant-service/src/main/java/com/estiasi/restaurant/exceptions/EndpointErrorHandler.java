package com.estiasi.restaurant.exceptions;

import com.estiasi.exceptions.DuplicateEntityFoundException;
import com.estiasi.exceptions.EntityNotFoundException;
import com.estiasi.exceptions.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EndpointErrorHandler {

    @ExceptionHandler({
            EntityNotFoundException.class,
            DuplicateEntityFoundException.class,
            IllegalArgumentException.class})
    public ResponseEntity<ErrorInfo> handleRestaurantNotFoundException(Exception ex) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

}
