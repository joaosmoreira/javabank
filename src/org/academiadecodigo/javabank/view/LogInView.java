package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.model.domain.Bank;

public class LogInView extends Viewer implements Show{
    //Falta controllers
    public LogInView(Bank bank) {
        super(bank);
    }

    private int scanCustmerId(){
        IntegerInputScanner scanner = new IntegerSetInputScanner(super.getBank().getCustomerIds());
        scanner.setMessage(Messages.CHOOSE_CUSTOMER);
        scanner.setError(Messages.ERROR_INVALID_CUSTOMER);

        return  super.getPrompt().getUserInput(scanner);
    }

    @Override
    public void show() {
        scanCustmerId();
    }
}
