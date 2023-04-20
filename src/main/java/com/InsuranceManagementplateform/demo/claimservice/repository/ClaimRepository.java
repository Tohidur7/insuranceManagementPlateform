package com.InsuranceManagementplateform.demo.claimservice.repository;

import com.InsuranceManagementplateform.demo.claimservice.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer> {
}
