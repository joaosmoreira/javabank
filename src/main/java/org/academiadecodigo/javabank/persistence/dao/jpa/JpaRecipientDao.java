package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.persistence.model.Recipient;
import org.academiadecodigo.javabank.persistence.dao.RecipientDao;
import org.springframework.stereotype.Repository;

@Repository
public class JpaRecipientDao extends GenericJpaDao<Recipient> implements RecipientDao {

    public JpaRecipientDao() {
        super(Recipient.class);
    }

}
