package com.gl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.gl.entity.Customer;

@Repository
public class CusSrvcImpl implements CusSrvc{
	
	private Session session;
	
	CusSrvcImpl(SessionFactory sessionFactory) {
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}

	@Transactional
	public List<Customer> findAll() {
		Transaction tx = session.beginTransaction();
		List<Customer> cus = session.createQuery("from Customer").list();
		tx.commit();
		return cus;
	}

	@Transactional
	public Customer findById(int theId) {
		Customer cus = new Customer();
		Transaction tx = session.beginTransaction();
		cus = session.get(Customer.class, theId);
		tx.commit();
		return cus;
	}

	@Transactional
	public void save(Customer cus) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(cus);
		tx.commit();
	}

	@Transactional
	public void delete(int theId) {
		Transaction tx = session.beginTransaction();
		Customer cus = session.get(Customer.class, theId);
		session.delete(cus);
		tx.commit();
	}

}
