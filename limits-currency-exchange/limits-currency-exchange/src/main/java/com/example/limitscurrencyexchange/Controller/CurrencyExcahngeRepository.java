package com.example.limitscurrencyexchange.Controller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExcahngeRepository extends JpaRepository<ExchangeValue,Long>{
 
	
	ExchangeValue findByFromAndTo(String from , String to);
}
