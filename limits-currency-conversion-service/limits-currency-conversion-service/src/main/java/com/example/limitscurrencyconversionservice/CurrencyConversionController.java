package com.example.limitscurrencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			
			) {
		
		HashMap<String,String> uriVariables=new HashMap<>();
		uriVariables.put("from",from);
		uriVariables.put("to",to);
		//uriVariables.put(conversionmultiple,conversionmultiple);
		ResponseEntity<CurrencyConversion> responseEntity=new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				CurrencyConversion.class,uriVariables);
		CurrencyConversion currencyConversion = responseEntity.getBody();
		return new CurrencyConversion(1000L,from,to,quantity,
				currencyConversion.getConversionmultiple(),
				quantity.multiply(currencyConversion.getConversionmultiple()),currencyConversion.getPort() + "" + "restTemplate");
	}
	
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionfeign(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			
			) {
		
		CurrencyConversion currencyConversion =currencyExchangeProxy.retrieveExchange(from, to);
		return new CurrencyConversion(1000L,from,to,quantity,
				currencyConversion.getConversionmultiple(),
				quantity.multiply(currencyConversion.getConversionmultiple()),currencyConversion.getPort() + " " + "feign");
	}

}
