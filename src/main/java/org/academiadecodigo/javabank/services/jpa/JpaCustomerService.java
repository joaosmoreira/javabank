package org.academiadecodigo.javabank.services.jpa;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.CustomerService;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
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
		
		try {
			CriteriaBuilder listBuilder = entityManager.getCriteriaBuilder ();
			CriteriaQuery<Customer> criteriaQuery = listBuilder.createQuery (Customer.class);
			Root<Customer> root = criteriaQuery.from (Customer.class);
			criteriaQuery.select (root);
			
			return entityManager.createQuery (criteriaQuery).getResultList ();
		} finally {
			if (entityManager != null) {
				entityManager.close ();
			}
		}
		
	}
	
	@Override
	public Set<Integer> listCustomerAccountIds (Integer id) {
		
		CriteriaBuilder setBuilder = entityManager.getCriteriaBuilder ();
		CriteriaQuery<Integer> criteriaQuery = setBuilder.createQuery (Integer.class);
		Root<Integer> root = criteriaQuery.from (Integer.class);
		criteriaQuery.select (root);
		
		return entityManager.createQuery (criteriaQuery).getResultList ().
	}
	
	@Override
	public double getBalance (int id) {
		return 0;
	}
	
	@Override
	public void add (Customer customer) {
	
	}
}