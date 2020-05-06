package com.wipro.microservice.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wipro.microservice.currencyconversionservice.controller.bean.CurrentConversionBean;

@RestController
public class CurrencyConversionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy exchangeProxy;
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrentConversionBean convertCurrencyFeign(@PathVariable String from, 
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		// Easy way to Communicate with Another Service using Feign Client
		CurrentConversionBean response = exchangeProxy.retrieveExchangeValue(from, to);

		logger.info("{}", response);
		return new CurrentConversionBean(response.getId(),from, to,
				response.getConversionMultiple(), quantity, 
				quantity.multiply(response.getConversionMultiple()), 
				response.getPort());
	}
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrentConversionBean convertCurrency(@PathVariable String from, 
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		
		// Complex way to Communicating with Another Microservice - Start
		Map<String, String> uriValues = new HashMap<String, String>();
		uriValues.put("from", from);
		uriValues.put("to", to);

		ResponseEntity<CurrentConversionBean> resEntity = 
				new RestTemplate().getForEntity(
						"http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
						CurrentConversionBean.class, uriValues);
		CurrentConversionBean response = resEntity.getBody();
		// Complex way to Communicating with Another Microservice - End

		return new CurrentConversionBean(response.getId(),from, to,
				response.getConversionMultiple(), quantity, 
				quantity.multiply(response.getConversionMultiple()), 
				response.getPort());
	}
}
