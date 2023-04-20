package com.InsuranceManagementplateform.demo.claimservice.responseData;

import java.util.Date;

public class ClaimErrorResponse {

    private Date timestamp ;
    private String message ;
    private String path ;

    public ClaimErrorResponse(Date timestamp, String message, String path) {
        this.timestamp = timestamp;
        this.message = message;
        this.path = path;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
