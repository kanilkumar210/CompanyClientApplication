package com.mindtree.companyclientapplication.dao.daoimpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mindtree.companyclientapplication.dao.CompanyDao;
import com.mindtree.companyclientapplication.entity.Company;
import com.mindtree.companyclientapplication.utility.GetSession;

public class CompanyDaoImpl implements CompanyDao {

	public Company getCompanyById(int id) {
		Session session = GetSession.getSession();
		Transaction tx = session.beginTransaction();
		Company company = session.find(Company.class, id);
		tx.commit();
		session.close();
		return company;
	}

}
