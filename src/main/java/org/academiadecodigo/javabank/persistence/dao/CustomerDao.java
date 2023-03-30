package org.academiadecodigo.javabank.persistence.dao;

import org.academiadecodigo.javabank.persistence.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends Dao<Customer> {

    List<Integer> getCustomerIds();
}
