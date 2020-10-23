package com.application.kafkaspringbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PoDownload {
	private int poNumber;
	private String poDate;
	private String poAddress;
	private String poLineNumber;
	private String upcNumber;
	private String upcName; 			//itemName
	private int orderedQuantity;
}
