package com.dtb.mymoneyappapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dtb.mymoneyappapi.model.entity.BillingCycles;

public interface BillingCyclesRepository extends MongoRepository<BillingCycles, String>{
	Optional<BillingCycles> findById(String id);
	List<BillingCycles> findAll();
	@SuppressWarnings("unchecked")
	BillingCycles save(BillingCycles billingCycles);
}
