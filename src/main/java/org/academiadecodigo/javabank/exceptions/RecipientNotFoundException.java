package org.academiadecodigo.javabank.exceptions;

public class RecipientNotFoundException extends NotFoundException {

    public RecipientNotFoundException() {
        super("Recipient Not Found");
    }
}
