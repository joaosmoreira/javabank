package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.exceptions.AccountNotFoundException;
import org.academiadecodigo.javabank.persistence.model.account.Account;

public interface AccountService {

    Account get(Integer id) throws AccountNotFoundException;

    void deposit(Integer id, double amount) throws AccountNotFoundException;

    void withdraw(Integer id, double amount) throws AccountNotFoundException;

    void transfer(Integer srcId, Integer dstId, double amount) throws AccountNotFoundException;
}
