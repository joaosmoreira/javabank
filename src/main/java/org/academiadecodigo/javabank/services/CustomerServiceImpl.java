package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.persistence.model.Recipient;
import org.academiadecodigo.javabank.persistence.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.AccountDao;
import org.academiadecodigo.javabank.persistence.dao.CustomerDao;
import org.academiadecodigo.javabank.persistence.dao.RecipientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.academiadecodigo.javabank.errors.ErrorMessage.*;

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

    public Customer get(Integer id) {
        return customerDao.findById(id);
    }

    @Override
    public double getBalance(Integer id) {

        Customer customer = Optional.ofNullable(customerDao.findById(id))
                .orElseThrow(() -> new IllegalArgumentException("Customer does not exist"));

        return customer.getAccounts().stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        customerDao.delete(id);
    }

    @Override
    public List<Customer> list() {
        return customerDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Recipient> listRecipients(Integer id) {

        // check then act logic requires transaction,
        // event if read only
        Customer customer = Optional.ofNullable(customerDao.findById(id))
                .orElseThrow(() -> new IllegalArgumentException("Customer does not exist"));

        return new ArrayList<>(customer.getRecipients());
    }

    @Transactional
    @Override
    public void removeRecipient(Integer id, Integer recipientId) {

        Customer customer = Optional.ofNullable(customerDao.findById(id))
                .orElseThrow(() -> new IllegalArgumentException(CUSTOMER_NOT_FOUND));

        Recipient recipient = Optional.ofNullable(recipientDao.findById(recipientId))
                .orElseThrow(() -> new IllegalArgumentException(RECIPIENT_NOT_FOUND));

        if (!recipient.getCustomer().getId().equals(id)) {
            throw new IllegalArgumentException(CUSTOMER_RECIPIENT_NOT_FOUND);
        }

        customer.removeRecipient(recipient);
        customerDao.saveOrUpdate(customer);
    }
    
    @Transactional
    @Override
    public Customer save (Customer customer) {
        customerDao.saveOrUpdate (customer);
        return customer;
    }
}
