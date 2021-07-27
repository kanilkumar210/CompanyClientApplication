package com.mindtree.companyclientapplication.dao.daoimpl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mindtree.companyclientapplication.dao.ClientDao;
import com.mindtree.companyclientapplication.entity.Client;
import com.mindtree.companyclientapplication.utility.GetSession;

public class ClientDaoImpl implements ClientDao {

	public Client addClientToTheCompany(Client client) {
		Session session = GetSession.getSession();
		Transaction tx = session.beginTransaction();
		session.save(client);
		tx.commit();
		session.close();
		return client;
	}

	public Set<Client> getClientsFromDatabase(int id) {
		Session session = GetSession.getSession();
		String sql = "from Client where companyId=" + id;
		Query query = session.createQuery(sql);
		List<Client> clientList = query.getResultList();
		Set<Client> clientSet = new LinkedHashSet<Client>(clientList);
		session.close();
		return clientSet;
	}

	public Client updateClientBudgetById(int id, long budget) {
		Session session = GetSession.getSession();
		Client client;
		Transaction tx = session.beginTransaction();
		client = session.find(Client.class, id);
		if (client == null) {
			return client;
		}
		client.setClientBudget(budget);
		session.persist(client);
		tx.commit();
		session.close();
		return client;

	}

}
