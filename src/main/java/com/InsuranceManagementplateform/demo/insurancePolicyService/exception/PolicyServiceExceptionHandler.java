package com.InsuranceManagementplateform.demo.insurancePolicyService.exception;

import com.InsuranceManagementplateform.demo.clientService.responseData.ClientErrorResponse;
import com.InsuranceManagementplateform.demo.insurancePolicyService.responseData.PolicyErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class PolicyServiceExceptionHandler {

    //handle specific exception
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<PolicyErrorResponse> handleEntityNotFoundException(EntityNotFoundException exception, WebRequest webRequest) {

        PolicyErrorResponse errorDetails = new PolicyErrorResponse(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
