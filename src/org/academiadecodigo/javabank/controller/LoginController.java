package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.domain.Bank;
import org.academiadecodigo.javabank.view.LogInView;

public class LoginController extends Controller implements Init{

    private LogInView logInView;
    private MenuController menuController;
    
    public LoginController (Bank bank) {
        super (bank);
    }
    
    
    @Override
    public void init() {
        logInView.setAccessingCustomerId(logInView.getAccessingCustomerId ());
        menuController.init();
    }
}
