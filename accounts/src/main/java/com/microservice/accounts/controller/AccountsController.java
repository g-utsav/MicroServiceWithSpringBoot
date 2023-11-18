package com.microservice.accounts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.accounts.bean.Customer;
import com.microservice.accounts.bean.Properties;
import com.microservice.accounts.config.AccountsServiceConfig;
import com.microservice.accounts.modal.Accounts;
import com.microservice.accounts.repository.AccountRepository;

@RestController
public class AccountsController {
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private AccountsServiceConfig accountsConfig;
	
	@PostMapping(path = "/myAccounts")
	public List<Accounts> getAccountDetails(@RequestBody Customer customer) {
		
		List<Accounts> account = accountRepo.findByCustomerId(customer.getCustomerId());
		
		if(account != null) {
			return account;
		}else {
			return null;
		}
		
	}
	
	@GetMapping("/accounts/properties")
	private String getPropertyDetails() throws JsonProcessingException {
		
		Properties properties = new Properties(accountsConfig.getMsg(),accountsConfig.getBuildVersion(),accountsConfig.getMailDetails(),
				accountsConfig.getActiveBranches());
		
		return new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(properties);
		
	}

}
