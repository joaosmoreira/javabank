package org.academiadecodigo.javabank.view;

import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.application.operations.NewAccountOperation;
import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.model.domain.Bank;

import java.util.HashMap;
import java.util.Map;

public class AccountView extends Viewer implements Show{
    //Falta controller
    public AccountView(Bank bank) {
        super(bank);
    }

    private Map<Integer, Operation> buildAccount(){
        Map<Integer, Operation> map = new HashMap<>();
        map.put(UserOptions.OPEN_ACCOUNT.getOption(),  new NewAccountOperation(this));

        return map;
    }

    @Override
    public void show() {
        buildAccount();
    }
}
