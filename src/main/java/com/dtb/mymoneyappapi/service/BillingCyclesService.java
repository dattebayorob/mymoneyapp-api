package com.dtb.mymoneyappapi.service;

import java.util.List;
import java.util.Optional;

import com.dtb.mymoneyappapi.model.entity.BillingCycles;

import io.vavr.control.Either;

public interface BillingCyclesService {
	Optional<List<BillingCycles>> findAll();
	Optional<BillingCycles> findById(String id);
	Either<RuntimeException, BillingCycles> update(BillingCycles cycles);
}
