package com.java.techie.paymentservice.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.techie.paymentservice.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {

}
