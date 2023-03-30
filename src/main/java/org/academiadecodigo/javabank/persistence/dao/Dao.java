package org.academiadecodigo.javabank.persistence.dao;

import org.academiadecodigo.javabank.persistence.model.Model;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Dao<T extends Model> {

    List<T> findAll();

    T findById(Integer id);

    T saveOrUpdate(T modelObject);

    void delete(Integer id);
}
