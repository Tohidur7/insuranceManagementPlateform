package com.InsuranceManagementplateform.demo.claimservice.entity;

import com.InsuranceManagementplateform.demo.claimservice.constant.ClaimStatus;
import com.InsuranceManagementplateform.demo.insurancePolicyService.entity.Policy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String claimNumber ;
    private String description ;
    @Temporal(TemporalType.DATE)
    private Date date ;

    @Enumerated(EnumType.STRING)
    private ClaimStatus claimStatus ;

    @ManyToOne
    private Policy policy ;

    public Claim() {
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

    @JsonIgnore
    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }
}

