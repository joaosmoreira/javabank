package org.academiadecodigo.javabank.view;

import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.application.operations.transaction.DepositOperation;
import org.academiadecodigo.javabank.model.domain.Bank;

import java.util.HashMap;
import java.util.Map;

public class DepositView extends Viewer implements Show{
    //falta controller
    public DepositView(Bank bank) {
        super(bank);
    }
    private Map<Integer, Operation> buildDeposit(){
        Map<Integer, Operation> map = new HashMap<>();
        map.put(UserOptions.DEPOSIT.getOption(), new DepositOperation(this));

        return map;
    }

    @Override
    public void show() {
      buildDeposit();
    }
}
