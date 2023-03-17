package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.services.*;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.bootStrap();
    }

    private void bootStrap() {

        Bootstrap bootstrap = new Bootstrap();
        ConnectionManager connectionManager = new ConnectionManager();

        JdbcAccountService jdbcAccountService = new JdbcAccountService();
        JdbcCustomerService jdbcCustomerService = new JdbcCustomerService();

        bootstrap.setAuthService(new AuthServiceImpl());

        jdbcCustomerService.setConnectionManager(connectionManager);
        jdbcAccountService.setConnectionManager(connectionManager);

        bootstrap.setCustomerService(jdbcCustomerService);
        bootstrap.setAccountService(jdbcAccountService);

        jdbcAccountService.setJdbcCustomerService(jdbcCustomerService);

        bootstrap.loadCustomers();
        Controller controller = bootstrap.wireObjects();

        controller.init();
    }
}
