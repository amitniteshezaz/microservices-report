package com.java.techie.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.techie.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
