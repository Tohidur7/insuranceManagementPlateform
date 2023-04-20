package com.InsuranceManagementplateform.demo.clientService.entity;

import com.InsuranceManagementplateform.demo.insurancePolicyService.entity.Policy;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String name ;

    @Temporal(TemporalType.DATE)
    private Date dob ;
    private String address ;
    private String contactInformation ;

    @OneToMany(mappedBy = "client")
    private List<Policy> policies = new ArrayList<>();

    public Client() {
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
        return this.policies;
    }

    public void setPolicies(List<Policy> policies) {
        this.policies = policies;
    }


}
