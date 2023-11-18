package com.microservice.accounts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.accounts.modal.Accounts;

@Repository
public interface AccountRepository extends JpaRepository<Accounts,Integer>{

	public List<Accounts> findByCustomerId(int customerId);
	
}
