package com.wipro.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wipro.microservice.bean.LimitConfiguration;
import com.wipro.microservice.config.Configuration;

@RestController
@EnableDiscoveryClient
public class LimitServiceConfigurationController {
	
	@Autowired
	private Configuration configuration;

	@GetMapping ("/limits")
	@HystrixCommand(fallbackMethod="rollbackRetireveConfiguration")
	public LimitConfiguration retrieveLimitsFromConfiguration() {
		//return new LimitConfiguration(1, 1000);
		return new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());
	}

	@GetMapping ("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod="rollbackRetireveConfiguration")	
	public LimitConfiguration retireveConfiguration() {
		throw new RuntimeException("Not Available");
	}
	
	public LimitConfiguration rollbackRetireveConfiguration() {
		return new LimitConfiguration(9,999);
	}
}
