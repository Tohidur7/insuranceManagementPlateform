package com.InsuranceManagementplateform.demo.claimservice.service;

import com.InsuranceManagementplateform.demo.claimservice.requestData.ClaimRequestData;
import com.InsuranceManagementplateform.demo.claimservice.responseData.ClaimResponseData;

import java.util.List;

public interface ClaimService {

    List<ClaimResponseData> getAllClaimData();

    ClaimResponseData getClaimDataById(int id);

    ClaimResponseData createClaim(ClaimRequestData claimRequestData);

    ClaimResponseData updateClaimData(int id, ClaimRequestData claimRequestData);

    String deleteClaimData(int id);
}
