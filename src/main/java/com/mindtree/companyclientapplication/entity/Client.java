package com.mindtree.companyclientapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Entity
public class Client {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clientId;
	private String clientName;
	private long clientBudget;
//	@ManyToOne(targetEntity = Company.class)
//	@JoinColumn(name = "companyId", referencedColumnName = "companyId")
	private Company company;

	public Client(int clientId, String clientName, long clientBudget, Company company) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientBudget = clientBudget;
		this.company = company;
	}

	public Client(String clientName, long clientBudget, Company company) {
		super();
		this.clientName = clientName;
		this.clientBudget = clientBudget;
		this.company = company;
	}

	public Client() {
		super();
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public long getClientBudget() {
		return clientBudget;
	}

	public void setClientBudget(long clientBudget) {
		this.clientBudget = clientBudget;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
