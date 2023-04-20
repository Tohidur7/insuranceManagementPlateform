package com.InsuranceManagementplateform.demo.clientService.responseData;

import com.InsuranceManagementplateform.demo.insurancePolicyService.entity.Policy;

import java.util.Date;
import java.util.List;

public class ClientResponseData {

    private int id ;
    private String name ;
    private Date dob ;
    private String address ;
    private String contactInformation ;
    private List<Policy> policies;

    public ClientResponseData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public List<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<Policy> policies) {
        this.policies = policies;
    }


}