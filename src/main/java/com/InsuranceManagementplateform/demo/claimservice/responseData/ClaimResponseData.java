package com.InsuranceManagementplateform.demo.claimservice.responseData;

import com.InsuranceManagementplateform.demo.claimservice.constant.ClaimStatus;

import java.util.Date;

public class ClaimResponseData {

    private int id ;
    private String claimNumber ;
    private String description ;
    private Date date ;
    private ClaimStatus claimStatus ;
    private int policyId ;

    public ClaimResponseData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
