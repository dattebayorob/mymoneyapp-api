package com.dtb.mymoneyappapi.model.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
@Document(collection = "billingcycles")
public class BillingCycles {
	@Id
	private String id;
	private String name;
	private Integer month;
	private Integer year;
	private List<Credit> credits;
	private List<Debit> debits;
	
	public BillingCycles() {
		// TODO Auto-generated constructor stub
	}
}
