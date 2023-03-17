package org.academiadecodigo.javabank.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private Connection connection = null;
    private String urlbd = "jdbc:mysql://localhost:3306/javaBankSQL";
    private String user = "root";
    private String pass = "";

    private JdbcAccountService jdbcAccountService;
    private JdbcCustomerService jdbcCustomerService;

    public void setJdbcAccountService(JdbcAccountService jdbcAccountService) {
        this.jdbcAccountService = jdbcAccountService;
    }

    public void setJdbcCustomerService(JdbcCustomerService jdbcCustomerService) {
        this.jdbcCustomerService = jdbcCustomerService;
    }

    public Connection getConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(urlbd, user, pass);
            }
        } catch (SQLException ex) {
            System.out.println("Failure to connect to database : " + ex.getMessage());
        }
        return connection;
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Failure to close database connections: " + ex.getMessage());
        }
    }
}
