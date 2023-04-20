package com.InsuranceManagementplateform.demo.claimservice.exception;

import com.InsuranceManagementplateform.demo.claimservice.responseData.ClaimErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ClaimServiceExceptionHandler extends ResponseEntityExceptionHandler {

    //handle specific exception
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ClaimErrorResponse> handleEntityNotFoundException(EntityNotFoundException exception, WebRequest webRequest) {

        ClaimErrorResponse errorDetails = new ClaimErrorResponse(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
