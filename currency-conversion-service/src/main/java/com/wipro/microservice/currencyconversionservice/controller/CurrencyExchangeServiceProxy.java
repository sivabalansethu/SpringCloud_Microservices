package com.wipro.microservice.currencyconversionservice.controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.microservice.currencyconversionservice.controller.bean.CurrentConversionBean;

//@FeignClient(name="currency-exchange-service", url="localhost:8000")

//@FeignClient(name="currency-exchange-service")
// Service 1 connects to API Gateway and redirects to Service 2...
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrentConversionBean retrieveExchangeValue(@PathVariable String from,
			@PathVariable String to);
}
