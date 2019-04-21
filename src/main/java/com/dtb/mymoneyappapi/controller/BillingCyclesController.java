package com.dtb.mymoneyappapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dtb.mymoneyappapi.model.dto.CountDto;
import com.dtb.mymoneyappapi.model.dto.ErrorsDto;
import com.dtb.mymoneyappapi.model.dto.SummaryDto;
import com.dtb.mymoneyappapi.model.entity.BillingCycles;
import com.dtb.mymoneyappapi.model.exception.CustomException;
import com.dtb.mymoneyappapi.service.BillingCyclesService;

@RestController
@RequestMapping("/api/billingCycles")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS,RequestMethod.PUT,RequestMethod.PATCH,RequestMethod.DELETE})
public class BillingCyclesController {
	private static final String NOT_FOUND = "Billing Cycle not found for this Id";
	private static final String EMPTY_COLLECTION = "Any billing cycle found for this filter";
	
	private BillingCyclesService service;

	public BillingCyclesController(BillingCyclesService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<BillingCycles>> findAll(){
		List<BillingCycles> billingCycles = service.findAll()
				.orElseThrow(()-> new CustomException(HttpStatus.NOT_FOUND,EMPTY_COLLECTION));
		
		return ResponseEntity.ok(billingCycles);
	}
	
	@GetMapping("/count")
	public ResponseEntity<CountDto> count(){
		CountDto count = CountDto.builder().value(service.count()).build();
		return ResponseEntity.ok(count);
	}
	
	@GetMapping("/summary")
	public ResponseEntity<SummaryDto> summary(){
		Map<String, Double> summary = service.summaryCreditsAndDebits();
		
		return ResponseEntity.ok(
				SummaryDto.builder()
					.credit(summary.get("credits"))
					.debit(summary.get("debits"))
					.build()
				);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BillingCycles> findById(@PathVariable String id){
		BillingCycles billingCycles = service.findById(id)
				.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, NOT_FOUND));
		return ResponseEntity.ok(billingCycles);
	}
	
	@PostMapping
	public ResponseEntity<Object> save(@Validated @RequestBody BillingCycles cycles){
		return ResponseEntity.ok(
				service.save(cycles).fold(ErrorsDto::exception, c -> c)
				);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> Update(@PathVariable String id, @Validated @RequestBody BillingCycles cycles){
		BillingCycles cyclesById = service.findById(id)
				.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, NOT_FOUND));
		
		cycles.set_id(id);
		
		return ResponseEntity.ok(service.update(cycles).fold(ErrorsDto::exception, c -> c));
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		BillingCycles cycles = service.findById(id)
				.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, NOT_FOUND));
		service.delete(cycles.get_id());
	}
}
