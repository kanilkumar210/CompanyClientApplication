package com.mindtree.companyclientapplication.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Entity
public class Company {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;
	private String companyName;
	// @OneToMany(targetEntity = Client.class, mappedBy = "company")
	private Set<Client> client;

	public Company(int companyId, String companyName, Set<Client> client) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.client = client;
	}

	public Company() {
		super();
	}

	public Company(int companyId) {
		super();
		this.companyId = companyId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Set<Client> getClient() {
		return client;
	}

	public void setClient(Set<Client> client) {
		this.client = client;
	}

}
