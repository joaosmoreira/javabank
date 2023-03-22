package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.persistence.SessionManager;
import org.academiadecodigo.javabank.persistence.dao.Dao;

import java.util.List;

public abstract class GenericJpaDao<T> implements Dao<T> {
	
	private Class<T> modelType;
	private SessionManager sm;
	
	public GenericJpaDao(Class<T> modelType, SessionManager sm){
		this.modelType = modelType;
		this.sm = sm;
	}
	
	@Override
	public List<T> findAll () {
		return null;
	}
	
	@Override
	public T findById (Integer id) {
		return null;
	}
	
	@Override
	public T saveOrUpdate (T t) {
		return null;
	}
	
	@Override
	public void delete (Integer id) {
	
	}
}
