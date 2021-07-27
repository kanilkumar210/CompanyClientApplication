package com.mindtree.companyclientapplication.dao;

import java.util.Set;

import com.mindtree.companyclientapplication.entity.Client;

public interface ClientDao {
	public Client addClientToTheCompany(Client client);

	public Set<Client> getClientsFromDatabase(int id);

	public Client updateClientBudgetById(int id, long budget);
}
