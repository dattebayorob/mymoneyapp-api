package com.dtb.mymoneyappapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Credit {
	private String name;
	private Integer value;
	
}
