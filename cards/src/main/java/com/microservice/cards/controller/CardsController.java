package com.microservice.cards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.cards.bean.Customer;
import com.microservice.cards.bean.Properties;
import com.microservice.cards.config.CardsServiceConfig;
import com.microservice.cards.modal.Cards;
import com.microservice.cards.repository.CardsRepository;

@RestController
public class CardsController {

	@Autowired
	CardsRepository cardsRepo;
	
	@Autowired
	CardsServiceConfig cardsConfig;
	
	@PostMapping("/myCards")
	public List<Cards> getCardDetails(@RequestBody Customer customer){
		List<Cards> cards = cardsRepo.findByCustomerId(customer.getCustomerId());
		
		if(cards != null) {
			return cards;
		}
		return null;
	}
	
	@GetMapping("/cards/properties")
	public String getProperties() throws JsonProcessingException {
		
		Properties property = new Properties(cardsConfig.getMsg(), cardsConfig.getBuildVersion(), cardsConfig.getMailDetails(),
				cardsConfig.getActiveBranches());
		
		return new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(property);
	}
	
}
