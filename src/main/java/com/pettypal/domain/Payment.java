package com.pettypal.domain;

import java.time.LocalDate;

public class Payment extends BaseEntityAudit {

	private long id;
	private String description;
	private double totalAmount;
	private double tax;
	private double tip;
	private LocalDate payment_date;
	
	

}
