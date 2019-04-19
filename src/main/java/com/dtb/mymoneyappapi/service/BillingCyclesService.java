package com.dtb.mymoneyappapi.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.dtb.mymoneyappapi.model.entity.BillingCycles;
import com.dtb.mymoneyappapi.model.exception.CustomException;

import io.vavr.control.Either;

public interface BillingCyclesService {
	Optional<List<BillingCycles>> findAll();
	Optional<BillingCycles> findById(String id);
	Either<CustomException, BillingCycles> save(BillingCycles cycles);
	Either<CustomException, BillingCycles> update(BillingCycles cycles);
	Long count();
	Map<String, Double> summaryCreditsAndDebits();
}
