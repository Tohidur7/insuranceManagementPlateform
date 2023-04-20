package com.InsuranceManagementplateform.demo.claimservice.controller;

import com.InsuranceManagementplateform.demo.claimservice.requestData.ClaimRequestData;
import com.InsuranceManagementplateform.demo.claimservice.responseData.ClaimResponseData;
import com.InsuranceManagementplateform.demo.claimservice.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ClaimController {


    private ClaimService claimService ;

    @Autowired
    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @GetMapping(path = "/claims")
    public ResponseEntity<List<ClaimResponseData>> getAllClaimData() {
        return new ResponseEntity<>(claimService.getAllClaimData(), HttpStatus.OK);
    }

    @GetMapping(path = "/claims/{id}")
    public ResponseEntity<ClaimResponseData> getClaimById(@PathVariable(name = "id") int id) {
        return new ResponseEntity<>(claimService.getClaimDataById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/claims")
    public ResponseEntity<ClaimResponseData> createClaim(@RequestBody ClaimRequestData claimRequestData) {
        return new ResponseEntity<>(claimService.createClaim(claimRequestData), HttpStatus.CREATED);
    }

    @PutMapping(path = "/claims/{id}")
    public ResponseEntity<ClaimResponseData> updateClaimData( @PathVariable(name = "id") int id,@RequestBody ClaimRequestData claimRequestData) {
        return new ResponseEntity<>(claimService.updateClaimData(id,claimRequestData), HttpStatus.OK);
    }

    @DeleteMapping(path = "/claims/{id}")
    public ResponseEntity<String> deleteClaimData( @PathVariable(name = "id") int id) {
        return new ResponseEntity<>(claimService.deleteClaimData(id), HttpStatus.OK);
    }




}
