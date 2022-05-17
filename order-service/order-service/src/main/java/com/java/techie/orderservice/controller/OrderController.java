package com.java.techie.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.techie.orderservice.common.Payment;
import com.java.techie.orderservice.common.TransactionRequest;
import com.java.techie.orderservice.common.TransactionResponse;
import com.java.techie.orderservice.entity.Order;
import com.java.techie.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@PostMapping("/bookorder")
	public TransactionResponse bookOrder(TransactionRequest request) {
//		Order order=request.getOrder();
//		Payment payment=request.getPayment();
//		payment.setOid(order.getOid());
//		payment.setAmount(order.getOprice());
//		
		
		return service.saveOrder(request);
	}
	
	@GetMapping("/getbook/{oid}")
	public List<Order> getAllBooks(@PathVariable int oid ) {
		return service.getAllBooks(oid);
	}
}
