package com.dtb.mymoneyappapi.model.entity;

import com.dtb.mymoneyappapi.model.enums.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Debit {
	private String name;
	private Integer value;
	private StatusEnum status;
}
