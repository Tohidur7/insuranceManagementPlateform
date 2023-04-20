package com.InsuranceManagementplateform.demo.insurancePolicyService.controller;

import com.InsuranceManagementplateform.demo.insurancePolicyService.requestData.PolicyRequestData;
import com.InsuranceManagementplateform.demo.insurancePolicyService.responseData.PolicyResponseData;
import com.InsuranceManagementplateform.demo.insurancePolicyService.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PolicyController {

    private PolicyService policyService;

    @Autowired
    public PolicyController(PolicyService insurancePolicyService) {
        this.policyService = insurancePolicyService;
    }

    @GetMapping(path = "/policies")
    public ResponseEntity<List<PolicyResponseData>> getAllPolicies() {

        return new ResponseEntity<>(policyService.getAllPolicies(), HttpStatus.OK);
    }

    @GetMapping(path = "/policies/{id}")
    public ResponseEntity<PolicyResponseData> getPolicyById(@PathVariable(name = "id") int id) {

        return new ResponseEntity<>(policyService.getPolicyById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/policies")
    public ResponseEntity<PolicyResponseData> createPolicies(@RequestBody PolicyRequestData policyRequestData) {

        return new ResponseEntity<>(policyService.createPolicies(policyRequestData), HttpStatus.CREATED);
    }

    @PutMapping(path = "/policies/{id}")
    public ResponseEntity<PolicyResponseData> updatePolicyData( @PathVariable(name = "id") int id ,@RequestBody PolicyRequestData policyRequestData) {

        return new ResponseEntity<>(policyService.updatePolicyData(id,policyRequestData), HttpStatus.OK);
    }

    @DeleteMapping(path = "/policies/{id}")
    public ResponseEntity<String> deletePolicyData( @PathVariable(name = "id") int id ) {

        return new ResponseEntity<>(policyService.deletePolicyData(id), HttpStatus.OK);
    }




}
