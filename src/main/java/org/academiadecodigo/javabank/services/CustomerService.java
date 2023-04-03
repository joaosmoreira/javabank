package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.persistence.model.Recipient;

import java.util.List;

public interface CustomerService {

    Customer get(Integer id);

    double getBalance(Integer id);

    void delete(Integer id);

    List<Customer> list();

    List<Recipient> listRecipients(Integer id);

    void removeRecipient(Integer id, Integer recipientId);
    
    Customer save(Customer customer);
}
