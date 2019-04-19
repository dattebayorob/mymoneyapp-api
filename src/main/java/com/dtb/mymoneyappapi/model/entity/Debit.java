package com.dtb.mymoneyappapi.model.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.dtb.mymoneyappapi.model.enums.StatusEnum;
import com.dtb.mymoneyappapi.model.validation.Enum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Debit {
	@Id
	private String _id;
	@NotNull(message = "Debit name must be informed")
	private String name;
	@NotNull(message = "Debit value must be informed")
	@Min(value = 0, message = "Debit value must start with 0 length")
	private Integer value;
	@Enum(enumClazz = StatusEnum.class, message = "Status informed isnt a valid attribut")
	private StatusEnum status;
	public Debit() {
		this._id = new ObjectId().toHexString();
	}
}
