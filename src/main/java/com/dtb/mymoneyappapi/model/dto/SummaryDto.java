package com.dtb.mymoneyappapi.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SummaryDto {
	private Double credit;
	private Double debit;
}
