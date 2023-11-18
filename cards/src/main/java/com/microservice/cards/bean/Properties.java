package com.microservice.cards.bean;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString
public class Properties {
	
	private String msg;
	private String buildVersion;
	private Map<String, String> mailDetails;
	private List<String> activeBranches;
	
	public Properties () {
		super();
	}
	
	public Properties(String msg, String buildVersion, Map<String, String> mailDetails, List<String> activeBranches) {
		super();
		this.msg = msg;
		this.buildVersion = buildVersion;
		this.mailDetails = mailDetails;
		this.activeBranches = activeBranches;
	}
	
}
