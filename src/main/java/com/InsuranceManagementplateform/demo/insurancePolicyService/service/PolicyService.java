package com.InsuranceManagementplateform.demo.insurancePolicyService.service;

import com.InsuranceManagementplateform.demo.insurancePolicyService.requestData.PolicyRequestData;
import com.InsuranceManagementplateform.demo.insurancePolicyService.responseData.PolicyResponseData;

import java.util.List;

public interface PolicyService {

    List<PolicyResponseData> getAllPolicies();

    PolicyResponseData getPolicyById(int id);

    PolicyResponseData createPolicies(PolicyRequestData policyRequestData);

    PolicyResponseData updatePolicyData(int id, PolicyRequestData policyRequestData);

    String deletePolicyData(int id);
}
