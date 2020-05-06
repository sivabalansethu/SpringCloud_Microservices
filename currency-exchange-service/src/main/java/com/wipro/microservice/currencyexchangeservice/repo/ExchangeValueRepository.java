package com.wipro.microservice.currencyexchangeservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.microservice.currencyexchangeservice.bean.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{
	ExchangeValue findByFromAndTo(String from, String to);
}
