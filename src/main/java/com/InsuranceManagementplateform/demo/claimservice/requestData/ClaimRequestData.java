package com.InsuranceManagementplateform.demo.claimservice.requestData;

import com.InsuranceManagementplateform.demo.claimservice.constant.ClaimStatus;
import jakarta.persistence.*;

import java.util.Date;

public class ClaimRequestData {

    private String claimNumber ;
    private String description ;
    private Date date ;
    private ClaimStatus claimStatus ;
    private int policyId ;


    public ClaimRequestData() {
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ClaimStatus getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(ClaimStatus claimStatus) {
        this.claimStatus = claimStatus;
    }

    public int getPolicyId() {
        return policyId;
    }

    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }
}

