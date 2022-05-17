package com.java.techie.paymentservice.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.techie.paymentservice.entity.Payment;
import com.java.techie.paymentservice.repositoty.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository repo;
	
	public Payment doPayment(Payment payment) {
		payment.setPaymentstatus(paymentProcessing());
		payment.setTransactionid(UUID.randomUUID().toString());
		return repo.save(payment);
	}
	
	public String paymentProcessing() {
		//api should 3rd party payment gateway (paytm,paypal)
		return new Random().nextBoolean()?"sucess":"false";
	}
	

}
