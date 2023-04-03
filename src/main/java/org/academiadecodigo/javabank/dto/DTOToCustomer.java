package org.academiadecodigo.javabank.dto;

import org.academiadecodigo.javabank.dto.model.CustomerDTO;
import org.academiadecodigo.javabank.persistence.model.Customer;

public class DTOToCustomer {
	
	private CustomerDTO customerDTO;
	private Customer customer;
	
	public Customer converter (CustomerDTO customerDTO) {

		customer = new Customer ();

		customer.setFirstName (customerDTO.getFirstName ());
		customer.setLastName (customerDTO.getLastName ());
		customer.setEmail (customerDTO.getEmail ());
		customer.setId (customerDTO.getId ());
		customer.setPhone (customerDTO.getPhone ());
		return customer;
	}
	
}
