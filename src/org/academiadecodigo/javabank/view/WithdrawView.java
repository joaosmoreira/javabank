package org.academiadecodigo.javabank.view;

import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.application.operations.transaction.WithdrawOperation;
import org.academiadecodigo.javabank.model.domain.Bank;

import java.util.HashMap;
import java.util.Map;

public class WithdrawView extends Viewer implements Show{
    //falta controller

    public WithdrawView(Bank bank) {
        super(bank);
    }

    private Map<Integer, Operation> buildWithdraw(){
        Map<Integer, Operation> map = new HashMap<>();
        map.put(UserOptions.WITHDRAW.getOption(),  new WithdrawOperation(this));

        return map;
    }

    @Override
    public void show() {
        buildWithdraw();
    }
}
