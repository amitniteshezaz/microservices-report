package com.java.techie.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java.techie.orderservice.common.Payment;
import com.java.techie.orderservice.common.TransactionRequest;
import com.java.techie.orderservice.common.TransactionResponse;
import com.java.techie.orderservice.entity.Order;
import com.java.techie.orderservice.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public TransactionResponse saveOrder(TransactionRequest request) {
		String response="";
		Order order=request.getOrder();
	    Payment payment=request.getPayment();
		payment.setOid(order.getOid());
	    payment.setAmount(order.getOprice());	
		
      Payment paymentResponse=restTemplate.postForObject("https:/localhost:9191/payment/dopayment",payment,Payment.class);
	response=paymentResponse.getPaymentstatus().equals("success")?"Payment Processing ":"failed some mistake";
      repo.save(order);
      return new TransactionResponse(order,paymentResponse.getTransactionid(),paymentResponse.getAmount(),response);
	}

	public List<Order> getAllBooks(int oid) {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	

}
