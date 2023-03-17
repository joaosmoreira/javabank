package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class JdbcCustomerService implements CustomerService {

    // decl de variaveis
    private ConnectionManager connectionManager;
    private int entryId;

    // atribuicao de valores
    public void setConnectionManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public Customer get(Integer id) {
        // cria novo customer
        Customer customer = new Customer();

        // decl de variaveis
        entryId = id;
        int result = 0;
        String name = "";

        try {
            // cria nova isst
            Statement getStatement = connectionManager.getConnection().createStatement();
            String queryGet = "SELECT * FROM customers WHERE customer_id='" + id + "'";
            ResultSet resultSet = getStatement.executeQuery(queryGet);

            // verifica se existe resultado
            if (resultSet.next()) {
                result = resultSet.getInt(1);
                name = resultSet.getString(2);
            }

            // define os dados obtidos
            customer.setId(result);
            customer.setName(name);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    // n fazer q so esta presente em testes
    public List<Customer> list() {
        return null;
    }

    public Set<Integer> listCustomerAccountIds(Integer id) {

        Set<Integer> accountList = new HashSet<>();

        try {
            Statement listAccountsStatement = connectionManager.getConnection().createStatement();
            String queryListAccounts = "SELECT * FROM accounts WHERE account_customer='" + id + "'";
            ResultSet resultSet = listAccountsStatement.executeQuery(queryListAccounts);

            while (resultSet.next()) {
                accountList.add(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accountList;
    }

    public double getBalance(int id) {

        int balance = 0;

        try {

            Statement balanceStatement = connectionManager.getConnection().createStatement();
            String queryBalance = "SELECT customer_balance FROM customers WHERE customer_id='" + id + "'";
            ResultSet resultSet = balanceStatement.executeQuery(queryBalance);

            while (resultSet.next()) {
                balance = balance + resultSet.getInt(3);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return balance;
    }

    public void add(Customer customer) {

        try {

            Statement addStatement = connectionManager.getConnection().createStatement();
            String queryAdd = "INSERT INTO customers (customer_name) VALUES ('" + customer + "')";
            addStatement.executeUpdate(queryAdd);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getEntryId() {
        return entryId;
    }
}
