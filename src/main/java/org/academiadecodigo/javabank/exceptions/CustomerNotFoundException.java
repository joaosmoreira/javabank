package org.academiadecodigo.javabank.exceptions;

public class CustomerNotFoundException extends NotFoundException {

    public CustomerNotFoundException() {
        super("Customer not found");
    }
}
