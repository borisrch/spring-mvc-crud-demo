package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// Need to inject the session factory	
	@Autowired
	private SessionFactory sessionFactory;
		
	@Override

	public List<Customer> getCustomers() {
		
		// Get the current hibernate session.
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create a query
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		// Execute query, and get result list.
		List<Customer> customers = theQuery.getResultList();		
		
		// Return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// Get current hibernate session.
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Save the customer to DB.
		currentSession.saveOrUpdate(theCustomer);
		
		
	}
	
	// READ customer from Hibernate.

	@Override
	public Customer getCustomer(int theId) {
		// Get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Read from Database using PK
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
		
	}

}
