package org.academiadecodigo.javabank.exceptions;

public class AssociationExistsException extends JavaBankException {

    public AssociationExistsException() {
        super("Entity contains association with another entity");
    }
}
