package com.feignclient.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.feignclient.model.Model;


@org.springframework.cloud.openfeign.FeignClient(url="https://coronavirus-19-api.herokuapp.com",name="FEIGN")

public interface FeignClient {
	
	@GetMapping("/feign")
	public List<Model> getCovidData();
	

}
