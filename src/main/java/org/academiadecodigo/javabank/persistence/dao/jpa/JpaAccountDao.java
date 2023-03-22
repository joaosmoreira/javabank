package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.persistence.jpa.JpaSessionManager;

import java.util.List;

public class JpaAccountDao extends GenericJpaDao<Account> {
	
	
	private JpaSessionManager sm;
	
	public JpaAccountDao(JpaSessionManager sm){
		
		super(Account.class, sm);
		this.sm=sm;
	}
	
	
	@Override
	public List<Account> findAll () {
		
		
		return null;
	}
	
	@Override
	public Account findById (Integer id) {
		return sm.getCurrentSession ().find (Account.class, id);
	}
	
	
	@Override
	public Account saveOrUpdate (Account account) {
		
		try {
			
			return sm.getCurrentSession ().merge (account);
		} finally {
			sm.stopSession ();
		}
	}
	
	
	@Override
	public void delete (Integer id) {
		try {
			
			sm.getCurrentSession ().remove (sm.getCurrentSession ().find (AccountType.class, id));
		} finally {
			sm.stopSession ();
		}
	}
}
