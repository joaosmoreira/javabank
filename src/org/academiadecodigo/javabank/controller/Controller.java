package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.model.domain.Bank;
import org.academiadecodigo.javabank.view.Viewer;

public abstract class Controller  {

    private Bank bank;

    public Controller(Bank bank) {
        this.bank = bank;
    }
    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
