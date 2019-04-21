package com.dtb.mymoneyappapi.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.dtb.mymoneyappapi.model.entity.BillingCycles;
import com.dtb.mymoneyappapi.model.entity.Credit;
import com.dtb.mymoneyappapi.model.entity.Debit;
import com.dtb.mymoneyappapi.model.exception.CustomException;
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
		return Optional.of(repository.findAll()).filter(l -> !l.isEmpty());
	}

	@Override
	public Optional<BillingCycles> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Either<CustomException, BillingCycles> update(BillingCycles cycles) {
		return Either.right(repository.save(cycles));
	}

	@Override
	public Either<CustomException, BillingCycles> save(BillingCycles cycles) {
		return Either.right(repository.save(cycles));
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public Map<String,Double> summaryCreditsAndDebits() {
		List<BillingCycles> cycles = repository.findAll();
		Double countCredits = cycles.stream()
				.filter(b -> b.getCredits() != null)
				.flatMap(c -> c.getCredits().stream())
				.collect(Collectors.summingDouble(Credit::getValue));
		Double countDebits = cycles.stream()
				.filter(b -> b.getDebits() != null)				
				.flatMap(d -> d.getDebits().stream())
				.collect(Collectors.summingDouble(Debit::getValue));
		Map<String, Double> summary = new HashMap<>();
		summary.put("credits", countCredits);
		summary.put("debits", countDebits);
		return summary;
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);
	}
	
	

}
