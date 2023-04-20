package com.InsuranceManagementplateform.demo.clientService.exception;

import com.InsuranceManagementplateform.demo.clientService.responseData.ClientErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ClientServiceExceptionHandler {
    //handle specific exception
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ClientErrorResponse> handleEntityNotFoundException(EntityNotFoundException exception, WebRequest webRequest) {

        ClientErrorResponse errorDetails = new ClientErrorResponse(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
