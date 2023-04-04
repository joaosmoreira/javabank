package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.exceptions.RecipientNotFoundException;
import org.academiadecodigo.javabank.persistence.model.Recipient;

public interface RecipientService {

    Recipient get(Integer id) throws RecipientNotFoundException;
}
