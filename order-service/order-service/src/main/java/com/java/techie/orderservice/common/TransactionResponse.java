package com.java.techie.orderservice.common;

import com.java.techie.orderservice.entity.Order;

public class TransactionResponse {
	private Order order;
	private String transactionId;
	private double amount;
	private String response;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public TransactionResponse(Order order, String transactionId, double amount, String response) {
		super();
		this.order = order;
		this.transactionId = transactionId;
		this.amount = amount;
		this.response = response;
	}
	public TransactionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TransactionResponse [order=" + order + ", transactionId=" + transactionId + ", amount=" + amount
				+ ", response=" + response + "]";
	}
	
	

}
