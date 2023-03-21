package org.academiadecodigo.javabank.services.jpa;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.CustomerService;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JpaCustomerService implements CustomerService {
	
	private AccountService accountService;
	private EntityManager entityManager;
	
	public JpaCustomerService (EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void setAccountService (AccountService accountService) {
		this.accountService = accountService;
	}
	
	@Override
	public Customer get (Integer id) {
		
		try {
			return entityManager.find (Customer.class, id);
		} finally {
			if (entityManager != null) {
				entityManager.close ();
			}
		}
		
	}
	
	@Override
	public List<Customer> list () {
		
		Map<Integer, Customer> customers = new HashMap<> ();
		
		re
		
	}
	
	@Override
	public Set<Integer> listCustomerAccountIds (Integer id) {
		return null;
	}
	
	@Override
	public double getBalance (int id) {
		return 0;
	}
	
	@Override
	public void add (Customer customer) {
	
	}
}