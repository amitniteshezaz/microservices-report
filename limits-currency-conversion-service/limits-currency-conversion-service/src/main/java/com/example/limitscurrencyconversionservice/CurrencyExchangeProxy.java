package com.example.limitscurrencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



//@FeignClient(name="limits-currency-conversion-service",url="localhost:8000")
@FeignClient(name="limits-currency-conversion-service")
public interface CurrencyExchangeProxy {
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchange(@PathVariable String from, @PathVariable String to);

}
