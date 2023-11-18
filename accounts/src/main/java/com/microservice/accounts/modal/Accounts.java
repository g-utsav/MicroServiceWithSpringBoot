package com.microservice.accounts.modal;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@Table(name="accounts")
public class Accounts {
	
	@Column(name="customer_id")
	private Integer customerId;
	
	@Id
	@Column(name="account_number")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountNumber;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="branch_address")
	private String branchAddress;
	
	@Column(name="created_dt")
	private LocalDate CreatedDt;

}
