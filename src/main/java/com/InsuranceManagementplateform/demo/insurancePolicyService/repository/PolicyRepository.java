package com.InsuranceManagementplateform.demo.insurancePolicyService.repository;

import com.InsuranceManagementplateform.demo.insurancePolicyService.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<Policy,Integer> {
}
