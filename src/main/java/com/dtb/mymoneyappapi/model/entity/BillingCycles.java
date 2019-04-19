package com.dtb.mymoneyappapi.model.entity;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
	private String _id;
	@NotNull(message = "Name must be informed")
	private String name;
	@NotNull(message = "Month must be infomed")
	@Min(value = 1, message = "Month must be between 1 and 12")
	@Max(value = 12, message = "Month must be between 1 and 12")	
	private Integer month;
	@NotNull(message = "Year must be informed")
	@Min(value = 1970, message = "Year must be between 1970 and 2100")
	@Max(value =  2100, message = "Year must be between 1970 and 2100")	
	private Integer year;
	private List<Credit> credits;
	private List<Debit> debits;
	
	public BillingCycles() {
		// TODO Auto-generated constructor stub
	}
}
