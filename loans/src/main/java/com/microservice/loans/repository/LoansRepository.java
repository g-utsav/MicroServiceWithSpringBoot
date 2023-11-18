package com.microservice.loans.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.loans.modal.Loans;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Integer>{

	List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId); 
	
}
