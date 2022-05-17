package com.example.limitscurrencyexchange.Controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyController {
	@Autowired
	private CurrencyExcahngeRepository repo;
	@Autowired
	private Environment environment;
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchange(@PathVariable String from, @PathVariable String to) {
		//ExchangeValue exchangeValue= new ExchangeValue(1000L,"USD","INR",BigDecimal.valueOf(70));
		ExchangeValue exchangeValue=repo.findByFromAndTo(from, to);
		if(exchangeValue==null) {
			throw new RuntimeException("Unable to find data for " + from +"to" + to);
		}
		exchangeValue.setPort((environment.getProperty("local.server.port")));
		return exchangeValue;
	}

}
