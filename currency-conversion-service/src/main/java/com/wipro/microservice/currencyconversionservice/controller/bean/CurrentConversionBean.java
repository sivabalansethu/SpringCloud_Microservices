package com.wipro.microservice.currencyconversionservice.controller.bean;

import java.math.BigDecimal;

public class CurrentConversionBean {

	private Long id;
	private String from;
	private String to;
	private BigDecimal quantity;
	private BigDecimal conversionMultiple;
	private BigDecimal totalCalculatedAmount;
	private int port;
	
	
	public CurrentConversionBean() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public BigDecimal getQuantity() {
		return quantity;
	}


	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}


	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}


	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}


	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}


	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}


	public CurrentConversionBean(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal totalCalculatedAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.conversionMultiple = conversionMultiple;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.port = port;
	}


	@Override
	public String toString() {
		return "CurrentConversionBean [id=" + id + ", from=" + from + ", to=" + to + ", quantity=" + quantity
				+ ", conversionMultiple=" + conversionMultiple + ", totalCalculatedAmount=" + totalCalculatedAmount
				+ ", port=" + port + "]";
	}
	
	
}
