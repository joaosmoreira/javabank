package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.exceptions.RecipientNotFoundException;
import org.academiadecodigo.javabank.persistence.dao.RecipientDao;
import org.academiadecodigo.javabank.persistence.model.Recipient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipientServiceImpl implements RecipientService {

    private RecipientDao recipientDao;

    @Autowired
    public void setRecipientDao(RecipientDao recipientDao) {
        this.recipientDao = recipientDao;
    }

    @Override
    public Recipient get(Integer id) throws RecipientNotFoundException {

        Recipient recipient = recipientDao.findById(id);

        if (recipient == null) {
            throw new RecipientNotFoundException();
        }

        return recipient;
    }
}
