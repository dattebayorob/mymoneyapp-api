package com.dtb.mymoneyappapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dtb.mymoneyappapi.model.entity.BillingCycles;
import com.dtb.mymoneyappapi.repository.BillingCyclesRepository;
import com.dtb.mymoneyappapi.service.BillingCyclesService;

import io.vavr.control.Either;

@Service
public class BillingCyclesServiceImpl implements BillingCyclesService {
	BillingCyclesRepository repository;

	public BillingCyclesServiceImpl(BillingCyclesRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<List<BillingCycles>> findAll() {
		return Optional.of(repository.findAll());
	}

	@Override
	public Optional<BillingCycles> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Either<RuntimeException, BillingCycles> update(BillingCycles cycles) {
		return Either.right(repository.save(cycles));
	}
	
	

}
