package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.exceptions.AccountNotFoundException;
import org.academiadecodigo.javabank.exceptions.AssociationExistsException;
import org.academiadecodigo.javabank.exceptions.CustomerNotFoundException;
import org.academiadecodigo.javabank.exceptions.RecipientNotFoundException;
import org.academiadecodigo.javabank.persistence.dao.AccountDao;
import org.academiadecodigo.javabank.persistence.dao.CustomerDao;
import org.academiadecodigo.javabank.persistence.dao.RecipientDao;
import org.academiadecodigo.javabank.persistence.model.AbstractModel;
import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.persistence.model.Recipient;
import org.academiadecodigo.javabank.persistence.model.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;
    private RecipientDao recipientDao;
    private AccountDao accountDao;

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Autowired
    public void setRecipientDao(RecipientDao recipientDao) {
        this.recipientDao = recipientDao;
    }

    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Customer get(Integer id) throws CustomerNotFoundException {

        Customer customer = customerDao.findById(id);

        if (customer == null) {
            throw new CustomerNotFoundException();
        }

        return customer;
    }

    @Override
    public double getBalance(Integer id) throws CustomerNotFoundException {

        Customer customer = Optional.ofNullable(customerDao.findById(id))
                .orElseThrow(CustomerNotFoundException::new);

        return customer.getAccounts().stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        return customerDao.saveOrUpdate(customer);
    }

    @Transactional
    @Override
    public void delete(Integer id) throws CustomerNotFoundException, AssociationExistsException {

        Customer customer = Optional.ofNullable(customerDao.findById(id))
                .orElseThrow(CustomerNotFoundException::new);

        if (!customer.getAccounts().isEmpty()) {
            throw new AssociationExistsException();
        }

        customerDao.delete(id);
    }

    @Override
    public List<Customer> list() {
        return customerDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Recipient> listRecipients(Integer id) throws CustomerNotFoundException {

        // check then act logic requires transaction,
        // event if read only

        Customer customer = Optional.ofNullable(customerDao.findById(id))
                .orElseThrow(CustomerNotFoundException::new);

        return new ArrayList<>(customer.getRecipients());
    }

    @Transactional
    @Override
    public void addRecipient(Integer id, Recipient recipient) throws CustomerNotFoundException, AccountNotFoundException {

        Customer customer = Optional.ofNullable(customerDao.findById(id))
                .orElseThrow(CustomerNotFoundException::new);

        if (accountDao.findById(recipient.getAccountNumber()) == null ||
                getAccountIds(customer).contains(recipient.getAccountNumber())) {
            throw new AccountNotFoundException();
        }

        customer.addRecipient(recipient);
        customerDao.saveOrUpdate(customer);

    }

    @Transactional
    @Override
    public void removeRecipient(Integer id, Integer recipientId) throws CustomerNotFoundException, RecipientNotFoundException {

        Customer customer = Optional.ofNullable(customerDao.findById(id))
                .orElseThrow(CustomerNotFoundException::new);

        Recipient recipient = Optional.ofNullable(recipientDao.findById(recipientId))
                .orElseThrow(RecipientNotFoundException::new);

        if (!customer.getRecipients().contains(recipient)) {
            throw new RecipientNotFoundException();
        }

        customer.removeRecipient(recipient);
        customerDao.saveOrUpdate(customer);
    }

    private Set<Integer> getAccountIds(Customer customer) {
        List<Account> accounts = customer.getAccounts();

        return accounts.stream()
                .map(AbstractModel::getId)
                .collect(Collectors.toSet());
    }
}
