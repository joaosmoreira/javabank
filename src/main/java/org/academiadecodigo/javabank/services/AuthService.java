package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.persistence.model.Customer;

public interface AuthService {

    boolean authenticate(Integer id);

    Customer getAccessingCustomer();
}
