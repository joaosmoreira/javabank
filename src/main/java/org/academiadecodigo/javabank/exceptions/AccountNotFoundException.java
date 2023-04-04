package org.academiadecodigo.javabank.exceptions;

public class AccountNotFoundException extends NotFoundException {

    public AccountNotFoundException() {
        super("Account not found");
    }
}
