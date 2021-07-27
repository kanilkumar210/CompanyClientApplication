package com.mindtree.companyclientapplication.service.service;

import java.util.LinkedHashSet;
import java.util.Set;

import com.mindtree.companyclientapplication.dao.ClientDao;
import com.mindtree.companyclientapplication.dao.CompanyDao;
import com.mindtree.companyclientapplication.dao.daoimpl.ClientDaoImpl;
import com.mindtree.companyclientapplication.dao.daoimpl.CompanyDaoImpl;
import com.mindtree.companyclientapplication.entity.Client;
import com.mindtree.companyclientapplication.exception.ServiceException;
import com.mindtree.companyclientapplication.exception.service.NoClientsPresentException;
import com.mindtree.companyclientapplication.exception.service.NoSuchCompanyIdPresentException;
import com.mindtree.companyclientapplication.service.ClientService;

public class ClientServiceImpl implements ClientService {

	private ClientDao clientDao = new ClientDaoImpl();
	private CompanyDao companyDao = new CompanyDaoImpl();

	
	public Client addClient(Client client) throws ServiceException {

		if (companyDao.getCompanyById(client.getCompany().getCompanyId()) == null) {
			throw new NoSuchCompanyIdPresentException();
		} else {
			return clientDao.addClientToTheCompany(client);
		}
	}

	public Set<Client> getClientsByCompanyId(int id) throws ServiceException {
		Set<Client> clientList = new LinkedHashSet<Client>();
		if (companyDao.getCompanyById(id) == null) {
			throw new NoSuchCompanyIdPresentException();
		} else {
			clientList = clientDao.getClientsFromDatabase(id);
			if (clientList.isEmpty()) {
				throw new NoClientsPresentException();
			}
		}
		return clientList;
	}

	public Client updateClientBudget(int id, long budget) throws ServiceException {
		Client client = clientDao.updateClientBudgetById(id, budget);
		if (client == null) {
			throw new NoClientsPresentException();
		} else {
			return client;
		}
	}
}
