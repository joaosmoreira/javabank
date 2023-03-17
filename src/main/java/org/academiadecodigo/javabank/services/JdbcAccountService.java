package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.account.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;

public class JdbcAccountService implements AccountService {

    // decl de variaveis
    private ConnectionManager connectionManager;
    private JdbcCustomerService jdbcCustomerService;

    // atribuicao de valores
    public void setJdbcCustomerService(JdbcCustomerService jdbcCustomerService) {
        this.jdbcCustomerService = jdbcCustomerService;
    }

    public void setConnectionManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    // metodo para adicionar uma nova account
    public void add(Account account) {
        try {
            // criada nova inst de statement
            Statement addStatement = connectionManager.getConnection().createStatement();
            String queryAdd = "INSERT INTO accounts((account_type, account_customer) VALUES ( " + account.getAccountType() + ", " + jdbcCustomerService.getEntryId() + ");";
            addStatement.executeUpdate(queryAdd);
            System.out.println("aqui mesmo");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // metodo para depositar na conta
    public void deposit(int id, double amount) {
        try {
            // criada nova inst de statement
            Statement depositStatement = connectionManager.getConnection().createStatement();
            String queryDeposit = "UPDATE account_balance FROM accounts WHERE account_id=' " + id + "'";
            depositStatement.executeQuery(queryDeposit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // metodo para fazer levantamento da conta
    public void withdraw(int id, double amount) {
        try {
            // criada nova inst de statement
            Statement withdrawStatement = connectionManager.getConnection().createStatement();
            String queryWithdraw = "UPDATE account_balance FROM accounts WHERE account_id='" + id + "'";
            withdrawStatement.executeQuery(queryWithdraw);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // metodo para fazer transferencia entre contas
    public void transfer(int srcId, int dstId, double amount) {

        try {
            // criada nova inst de statement
            Statement transferStatement = connectionManager.getConnection().createStatement();

            String queryTransferOut = "UPDATE account_balance FROM accounts WHERE account_id='" + srcId + "'";
            String queryTransferIn = "UPDATE account_balance FROM accounts WHERE account_id='" + dstId + "'";

            transferStatement.executeQuery(queryTransferOut);
            transferStatement.executeQuery(queryTransferIn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
