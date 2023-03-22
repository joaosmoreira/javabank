package org.academiadecodigo.javabank.services.jpa;

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.jpa.JpaAccountDao;
import org.academiadecodigo.javabank.persistence.jpa.JpaTransactionManager;
import org.academiadecodigo.javabank.services.AccountService;

import javax.persistence.RollbackException;
import java.util.Optional;

/**
 * A JPA {@link AccountService} implementation
 */
public class JpaAccountService implements AccountService {
	
	// private EntityManagerFactory emf;
	private JpaTransactionManager tm;
	
	
	public JpaAccountService (JpaTransactionManager tm) {
		this.tm = tm;
	}
	private JpaAccountDao accountDao;
	
	@Override
	public Account save (Account account) {
		
		try {
			tm.beginWrite ();
			
			return accountDao.saveOrUpdate (account);
		} finally {
			tm.commit ();
		}
	}
	
	/**
	 * @see AccountService#deposit(Integer, double)
	 */
	@Override
	public void deposit (Integer id, double amount) {
		
		try {
			Optional<Account> account = Optional.ofNullable (accountDao.findById (id));
			if (!account.isPresent ()) {
				tm.rollback ();
			}
			account.orElseThrow (() -> new IllegalArgumentException ("invalid account id")).credit (amount);
			tm.commit ();
		} catch (RollbackException ex) {
			tm.rollback ();
		} finally {
		
		}
	}
	
	/**
	 * @see AccountService#withdraw(Integer, double)
	 */
	@Override
	public void withdraw (Integer id, double amount) {
		
		try {
			
			Optional<Account> account = Optional.ofNullable (accountDao.findById (id));
			
			if (!account.isPresent ()) {
				tm.rollback ();
			}
			
			account.orElseThrow (() -> new IllegalArgumentException ("invalid account id")).debit (amount);
			tm.commit ();
			
		} catch (RollbackException ex) {
			
			tm.rollback ();
			
		} finally {
			
		
		}
	}
	
	/**
	 * @see AccountService#transfer(Integer, Integer, double)
	 */
	@Override
	public void transfer (Integer srcId, Integer dstId, double amount) {
		
		try {
			
			Optional<Account> srcAccount = Optional.ofNullable (accountDao.findById (srcId));
			Optional<Account> dstAccount = Optional.ofNullable (accountDao.findById (dstId));
			
			if (!srcAccount.isPresent () || !dstAccount.isPresent ()) {
				tm.rollback ();
			}
			
			srcAccount.orElseThrow (() -> new IllegalArgumentException ("invalid account id"));
			dstAccount.orElseThrow (() -> new IllegalArgumentException ("invalid account id"));
			
			// make sure transaction can be performed
			if (srcAccount.get ().canDebit (amount) && dstAccount.get ().canCredit (amount)) {
				srcAccount.get ().debit (amount);
				dstAccount.get ().credit (amount);
			}
			
			tm.commit ();
			
		} catch (RollbackException ex) {
			
			tm.rollback ();
			
		} finally {
			
			
			}
		}
	}
	

