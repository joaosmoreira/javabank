package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.persistence.dao.CustomerDao;
import org.academiadecodigo.javabank.persistence.jpa.JpaSessionManager;

import java.util.List;

public class JpaCustomerDao extends GenericJpaDao<Customer> implements CustomerDao {
	
	
	private JpaSessionManager sm;
	
	public JpaCustomerDao(JpaSessionManager sm){
		
		super(Customer.class, sm);
		this.sm=sm;
	}
	
	
	@Override
	public List<Customer> findAll () {
		return null;
	}
	
	@Override
	public Customer findById (Integer id) {
		return sm.getCurrentSession ().find (Customer.class, id);
	}
	
	@Override
	public void delete (Integer id){
		try {
			
			sm.getCurrentSession ().remove (sm.getCurrentSession ().find (Customer.class, id));
		} finally {
		sm.stopSession ();
		}
	}
	
	
	@Override
	public Customer saveOrUpdate (Customer customer) {
		
		try {
			
			return sm.getCurrentSession ().merge (customer);
		} finally {
			sm.stopSession ();
		}
	}
}
