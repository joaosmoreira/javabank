package org.academiadecodigo.javabank.view;

import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.application.operations.BalanceOperation;
import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.model.domain.Bank;

import java.util.HashMap;
import java.util.Map;

public class BalanceView extends Viewer implements Show {
    //falta ligação com o controller;

    public BalanceView(Bank bank) {
        super(bank);
    }

    private Map<Integer, Operation> buildBalance(){
        Map<Integer, Operation> map = new HashMap<>();
        map.put(UserOptions.GET_BALANCE.getOption(), new BalanceOperation(this));

    return map;
    }

    @Override
    public void show() {
       buildBalance();
    }
}
