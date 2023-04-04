package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.exceptions.AccountNotFoundException;
import org.academiadecodigo.javabank.exceptions.AssociationExistsException;
import org.academiadecodigo.javabank.exceptions.CustomerNotFoundException;
import org.academiadecodigo.javabank.exceptions.RecipientNotFoundException;
import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.persistence.model.Recipient;

import java.util.List;

public interface CustomerService {

    Customer get(Integer id) throws CustomerNotFoundException;

    double getBalance(Integer id) throws CustomerNotFoundException;

    Customer save(Customer customer);

    void delete(Integer id) throws CustomerNotFoundException, AssociationExistsException;

    List<Customer> list();

    List<Recipient> listRecipients(Integer id) throws CustomerNotFoundException;

    void addRecipient(Integer id, Recipient recipient) throws CustomerNotFoundException, AccountNotFoundException;

    void removeRecipient(Integer id, Integer recipientId) throws CustomerNotFoundException, RecipientNotFoundException;
}
