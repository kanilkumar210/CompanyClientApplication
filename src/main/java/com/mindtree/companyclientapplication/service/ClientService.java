package com.mindtree.companyclientapplication.service;

import java.util.Set;

import com.mindtree.companyclientapplication.entity.Client;
import com.mindtree.companyclientapplication.exception.ServiceException;

public interface ClientService {
	
	public Client addClient(Client client) throws ServiceException;

	public Set<Client> getClientsByCompanyId(int id) throws ServiceException;

	public Client updateClientBudget(int id, long budget) throws ServiceException;

}
