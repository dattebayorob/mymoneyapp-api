package com.dtb.mymoneyappapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dtb.mymoneyappapi.model.entity.BillingCycles;
import com.dtb.mymoneyappapi.service.BillingCyclesService;

@RestController
@RequestMapping("/api/billingCycles")
public class BillingCyclesController {
	private BillingCyclesService service;

	public BillingCyclesController(BillingCyclesService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<BillingCycles>> findAll(){
		List<BillingCycles> billingCycles = service.findAll()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Empty List"));
		return ResponseEntity.ok(billingCycles);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BillingCycles> findById(@PathVariable String id){
		BillingCycles billingCycles = service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Billing Cycle not found for this Id"));
		return ResponseEntity.ok(billingCycles);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> Update(@PathVariable String id, @Validated @RequestBody BillingCycles cycles){
		BillingCycles cyclesById = service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Billing Cycle not found for this Id"));
		cycles.setId(id);
		return ResponseEntity.ok(
				service.update(cycles)
				.getOrElseThrow(e -> new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage()))
				);
		
	}
	
	
}
