package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.persistence.model.Recipient;

import java.util.List;
import java.util.Set;

public interface CustomerService {

    Customer get(Integer id);

    double getBalance(Integer id);

    Set<Integer> listCustomerAccountIds(Integer id);

    List<Recipient> listRecipients(Integer id);
    
    List<Customer> findAll();
}
