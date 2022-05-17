package com.java.techie.paymentservice.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PAYMENT_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	@Id
	@GeneratedValue
	private int paymentid;
	private String paymentstatus;
	private String transactionid;
	private int oid;
	private int amount;
	public int getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}
	public String getPaymentstatus() {
		return paymentstatus;
	}
	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Payment(int paymentid, String paymentstatus, String transactionid, int oid, int amount) {
		super();
		this.paymentid = paymentid;
		this.paymentstatus = paymentstatus;
		this.transactionid = transactionid;
		this.oid = oid;
		this.amount = amount;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Payment [paymentid=" + paymentid + ", paymentstatus=" + paymentstatus + ", transactionid="
				+ transactionid + ", oid=" + oid + ", amount=" + amount + "]";
	}
	
	
}
