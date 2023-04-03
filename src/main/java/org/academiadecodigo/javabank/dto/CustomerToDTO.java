package org.academiadecodigo.javabank.dto;

import org.academiadecodigo.javabank.dto.model.CustomerDTO;
import org.academiadecodigo.javabank.persistence.model.Customer;

public class CustomerToDTO {
	
	private CustomerDTO customerDTO;
	private Customer customer;
	
	public CustomerDTO customerDTO (Customer customer) {
		customerDTO = new CustomerDTO ();
		
		customerDTO.setId (customer.getId ());
		customerDTO.setFirstName (customer.getFirstName ());
		customerDTO.setLastName (customer.getLastName ());
		customerDTO.setEmail (customer.getEmail ());
		customerDTO.setPhone (customer.getPhone ());
		return customerDTO;
	}
	
}
