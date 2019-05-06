package com.example.itemservice.advices;

import com.example.itemservice.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * User: edward <br/>
 * Date: 5/5/19 8:58 PM <br/>
 */
@ControllerAdvice
public class ItemAdvice {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<ErrorMessage> handleResourceNotFound(HttpServletRequest request, Exception exception){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setCode(HttpStatus.NOT_FOUND.toString());
        errorMessage.setErrorMessage(exception.getMessage());
        errorMessage.setPath(request.getRequestURI());
        errorMessage.setTimestamp(new Date());

        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
