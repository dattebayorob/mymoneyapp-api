package com.dtb.mymoneyappapi.model.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@Document(collection = "credit")
public class Credit {
	@Id
	private String _id;
	@NotNull(message = "Credit name must be informed")
	private String name;
	@NotNull(message = "Credit value must be informed")
	@Min(value=0, message = "Credit value must start with 0 length")
	private Integer value;
	public Credit() {
		this._id = new ObjectId().toHexString();
	}
	
}
