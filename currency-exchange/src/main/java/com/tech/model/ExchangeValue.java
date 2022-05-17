package com.tech.model;

import java.math.BigDecimal;

public class ExchangeValue {
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionmultiple;
	private String port;
	
	public String getPort() {
		return port;
	}
	public void setPort(String string) {
		this.port = string;
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
	public BigDecimal getConversionmultiple() {
		return conversionmultiple;
	}
	public void setConversionmultiple(BigDecimal conversionmultiple) {
		this.conversionmultiple = conversionmultiple;
	}
	public ExchangeValue(Long id, String from, String to, BigDecimal conversionmultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionmultiple = conversionmultiple;
	}
	public ExchangeValue() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
