package org.academiadecodigo.javabank.persistence.dao;

import java.util.List;

public interface Dao <T>{
	
	List<T> findAll();
	T findById(Integer id);
	T saveOrUpdate(T t);
	void delete(Integer id);
	
}
