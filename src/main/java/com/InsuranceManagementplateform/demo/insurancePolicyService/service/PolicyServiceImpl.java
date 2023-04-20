package com.InsuranceManagementplateform.demo.insurancePolicyService.service;

import com.InsuranceManagementplateform.demo.claimservice.constant.Constants;
import com.InsuranceManagementplateform.demo.clientService.entity.Client;
import com.InsuranceManagementplateform.demo.clientService.repository.ClientRepository;
import com.InsuranceManagementplateform.demo.insurancePolicyService.entity.Policy;
import com.InsuranceManagementplateform.demo.insurancePolicyService.exception.EntityNotFoundException;
import com.InsuranceManagementplateform.demo.insurancePolicyService.repository.PolicyRepository;
import com.InsuranceManagementplateform.demo.insurancePolicyService.requestData.PolicyRequestData;
import com.InsuranceManagementplateform.demo.insurancePolicyService.responseData.PolicyResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PolicyServiceImpl implements PolicyService {

    private PolicyRepository policyRepository;
    private ClientRepository clientRepository ;

    @Autowired
    public PolicyServiceImpl(PolicyRepository policyRepository, ClientRepository clientRepository) {
        this.policyRepository = policyRepository;
        this.clientRepository = clientRepository ;
    }

    @Override
    public List<PolicyResponseData> getAllPolicies() {

        List<Policy> all = policyRepository.findAll();
        return all.stream().map(policy -> mapToDto(policy)).collect(Collectors.toList());
    }

    @Override
    public PolicyResponseData getPolicyById(int id) {
        Optional<Policy> byId = policyRepository.findById(id);
        if (byId.isEmpty()) {
            throw new EntityNotFoundException("policy is not found with the given id") ;
        }

        Policy policy = byId.get();
        return mapToDto(policy);
    }

    @Override
    public PolicyResponseData createPolicies(PolicyRequestData policyRequestData) {

        Policy policy = mapToEntity(policyRequestData);
        Policy save = policyRepository.save(policy);
        return mapToDto(save);
    }

    @Override
    public PolicyResponseData updatePolicyData(int id, PolicyRequestData policyRequestData) {

        Optional<Policy> byId = policyRepository.findById(id);
        if (byId.isEmpty()) {
            throw new EntityNotFoundException("policy data is not found with the given id");
        }
        Policy policy = byId.get();

        Optional<Client> byId1 = clientRepository.findById(policyRequestData.getClientId());
        if (byId1.isEmpty()) {
            throw new EntityNotFoundException("client is is not valid");
        }
        policy.setPolicyNumber(policyRequestData.getPolicyNumber());
        policy.setPolicyType(policyRequestData.getPolicyType());
        policy.setCoverageAmount(policyRequestData.getCoverageAmount());
        policy.setPremium(policyRequestData.getPremium());
        policy.setStartDate(policyRequestData.getStartDate());
        policy.setEndDate(policyRequestData.getEndDate());
        policy.setClient(byId1.get());

        policyRepository.save(policy);

        return mapToDto(policy) ;
    }

    @Override
    public String deletePolicyData(int id) {
        Optional<Policy> byId = policyRepository.findById(id);
        if (byId.isEmpty()) {
            throw new EntityNotFoundException("policy data is not found with the given id");
        }
        Policy policy = byId.get();
        policyRepository.delete(policy);

        return Constants.DELETE_MESSAGE ;
    }


    /**
     * METHOD TO CONVERT ENTITY OBJECT INTO RESPONSE OBJECT
     * @param policy
     * @return
     */
    private PolicyResponseData mapToDto(Policy policy) {

        PolicyResponseData policyResponseData = new PolicyResponseData();

        policyResponseData.setId(policy.getId());
        policyResponseData.setPolicyNumber(policy.getPolicyNumber());
        policyResponseData.setPolicyType(policy.getPolicyType());
        policyResponseData.setCoverageAmount(policy.getCoverageAmount());
        policyResponseData.setPremium(policy.getPremium());
        policyResponseData.setStartDate(policy.getStartDate());
        policyResponseData.setEndDate(policy.getEndDate());
        policyResponseData.setClientId(policy.getClient().getId());
        policyResponseData.setClaims(policy.getClaims());

        return policyResponseData ;
    }

    /**
     * METHOD TO CONVERT REQUEST OBJECT INTO ENTITY
     * @param
     * @return
     */
    private Policy mapToEntity(PolicyRequestData policyRequestData) {

        Policy policy = new Policy();

        policy.setPolicyNumber(policyRequestData.getPolicyNumber());
        policy.setPolicyType(policyRequestData.getPolicyType());
        policy.setCoverageAmount(policyRequestData.getCoverageAmount());
        policy.setPremium(policyRequestData.getPremium());
        policy.setStartDate(policyRequestData.getStartDate());
        policy.setEndDate(policyRequestData.getStartDate());

        Optional<Client> byId = clientRepository.findById(policyRequestData.getClientId());
        if (byId.isEmpty()) {
            throw new EntityNotFoundException("client id is invalid");
        }
        policy.setClient(byId.get());

        return policy ;
    }
}
