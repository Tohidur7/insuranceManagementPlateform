package com.InsuranceManagementplateform.demo.claimservice.service;

import com.InsuranceManagementplateform.demo.claimservice.constant.Constants;
import com.InsuranceManagementplateform.demo.claimservice.entity.Claim;
import com.InsuranceManagementplateform.demo.claimservice.exception.EntityNotFoundException;
import com.InsuranceManagementplateform.demo.claimservice.repository.ClaimRepository;
import com.InsuranceManagementplateform.demo.claimservice.requestData.ClaimRequestData;
import com.InsuranceManagementplateform.demo.claimservice.responseData.ClaimResponseData;
import com.InsuranceManagementplateform.demo.insurancePolicyService.entity.Policy;
import com.InsuranceManagementplateform.demo.insurancePolicyService.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClaimServiceImpl implements ClaimService {

    private ClaimRepository claimRepository ;
    private PolicyRepository policyRepository ;

    @Autowired
    public ClaimServiceImpl(ClaimRepository claimRepository, PolicyRepository policyRepository) {
        this.claimRepository = claimRepository;
        this.policyRepository = policyRepository ;
    }

    @Override
    public List<ClaimResponseData> getAllClaimData() {
        List<Claim> claims = claimRepository.findAll();
        return claims.stream().map(claim -> mapToDto(claim)).collect(Collectors.toList());
    }

    @Override
    public ClaimResponseData getClaimDataById(int id) {

        Optional<Claim> byId = claimRepository.findById(id);
        if (byId.isEmpty()) {
            throw new EntityNotFoundException("Claim Data not found with the given id");
        }
        Claim claim = byId.get();
        return mapToDto(claim);
    }

    @Override
    public ClaimResponseData createClaim(ClaimRequestData claimRequestData) {

        Claim claim = mapToEntity(claimRequestData);
        Claim save = claimRepository.save(claim);
        return mapToDto(save);
    }

    @Override
    public ClaimResponseData updateClaimData(int id, ClaimRequestData claimRequestData) {


        Optional<Claim> byId = claimRepository.findById(id);
        if (byId.isEmpty()) {
            throw new EntityNotFoundException("policy is not found with given id");
        }

        Optional<Policy> byId1 = policyRepository.findById(claimRequestData.getPolicyId());
        if (byId1.isEmpty()) {
            throw new EntityNotFoundException("policy id is not valid ");
        }
        Claim claim = byId.get();

        //update all data
        claim.setClaimNumber(claimRequestData.getClaimNumber());
        claim.setClaimStatus(claimRequestData.getClaimStatus());
        claim.setDate(claimRequestData.getDate());
        claim.setDescription(claimRequestData.getDescription());
        claim.setPolicy(byId1.get());
        claimRepository.save(claim);
        return mapToDto(claim);
    }

    @Override
    public String deleteClaimData(int id) {
        Optional<Claim> byId = claimRepository.findById(id);
        if (byId.isEmpty()) {
            throw new EntityNotFoundException("Claim Data not found with the given id");
        }
        Claim claim = byId.get();
        claimRepository.delete(claim);
        return Constants.DELETE_MESSAGE ;
    }


    /**
     * METHOD TO CONVERT ENTITY OBJECT ONTO RESPONSE OBJECT
     * @param claim
     * @return
     */
    private ClaimResponseData mapToDto(Claim claim) {
        ClaimResponseData claimResponseData = new ClaimResponseData();

        claimResponseData.setId(claim.getId());
        claimResponseData.setClaimNumber(claim.getClaimNumber());
        claimResponseData.setClaimStatus(claim.getClaimStatus());
        claimResponseData.setDate(claim.getDate());
        claimResponseData.setDescription(claim.getDescription());
        claimResponseData.setPolicyId(Math.toIntExact(claim.getPolicy().getId()));


        return claimResponseData ;
    }

    /**
     * METHOD TO CONVERT REQUEST OBJECT INTO ENTITY OBJECT
     * @param claimRequestData
     * @return
     */
    private Claim mapToEntity(ClaimRequestData claimRequestData) {

        Claim claim = new Claim();

        claim.setClaimNumber(claimRequestData.getClaimNumber());
        claim.setClaimStatus(claimRequestData.getClaimStatus());
        claim.setDate(claimRequestData.getDate());
        claim.setDescription(claimRequestData.getDescription());

        Optional<Policy> byId = policyRepository.findById(claimRequestData.getPolicyId());
        if (byId.isEmpty()) {
            throw new EntityNotFoundException("policy id is not valid");
        }
        claim.setPolicy(byId.get());

        return claim ;
    }

}
