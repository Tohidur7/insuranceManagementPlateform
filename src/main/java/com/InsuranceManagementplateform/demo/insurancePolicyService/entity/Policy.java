package com.InsuranceManagementplateform.demo.insurancePolicyService.entity;

import com.InsuranceManagementplateform.demo.claimservice.entity.Claim;
import com.InsuranceManagementplateform.demo.clientService.entity.Client;
import com.InsuranceManagementplateform.demo.insurancePolicyService.constant.PolicyType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String policyNumber ;
    @Enumerated(EnumType.STRING)
    private PolicyType policyType ;
    private double coverageAmount ;
    private double premium ;

    @Temporal(TemporalType.DATE)
    private Date startDate ;
    @Temporal(TemporalType.DATE)
    private Date endDate ;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client ;

    @OneToMany(mappedBy = "policy")
    private List<Claim> claims = new ArrayList<>();

    public Policy() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public PolicyType getPolicyType() {
        return policyType;
    }

    public void setPolicyType(PolicyType policyType) {
        this.policyType = policyType;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(double coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @JsonIgnore
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Claim> getClaims() {
        return claims;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }
}
