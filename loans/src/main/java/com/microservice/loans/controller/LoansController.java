package com.microservice.loans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.loans.bean.Customer;
import com.microservice.loans.bean.Properties;
import com.microservice.loans.config.LoansServiceConfig;
import com.microservice.loans.modal.Loans;
import com.microservice.loans.repository.LoansRepository;

@RestController
public class LoansController {

	@Autowired
	LoansRepository loansRepo;
	
	@Autowired
	LoansServiceConfig loansConfig;
	
	@PostMapping("/myLoans")
	public List<Loans> getLoanDetails(@RequestBody Customer customer){
		
		List<Loans> loans = loansRepo.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
		
		if(loans != null) {
			return loans;
		}else {
			return null;
		}
	}
	
	@GetMapping("/loans/properties")
	public String getProperty() throws JsonProcessingException {
		Properties properties = new Properties(loansConfig.getMsg(), loansConfig.getBuildVersion(), loansConfig.getMailDetails(),
				loansConfig.getActiveBranches());
		
		return new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(properties);
	}
	
}
