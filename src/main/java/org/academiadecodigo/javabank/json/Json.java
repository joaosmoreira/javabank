package org.academiadecodigo.javabank.json;


import org.academiadecodigo.javabank.command.CustomerDto;
import org.academiadecodigo.javabank.converters.AccountToAccountDto;
import org.academiadecodigo.javabank.converters.CustomerToCustomerDto;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Json {

	private CustomerService customerService;
	private CustomerToCustomerDto customerToCustomerDto;
	private AccountService accountService;
	private AccountToAccountDto accountToAccountDto;
	
	@Autowired
	public void setAccountService (AccountService accountService) {
		this.accountService = accountService;
	}
	
	@Autowired
	public void setAccountToAccountDto (AccountToAccountDto accountToAccountDto) {
		this.accountToAccountDto = accountToAccountDto;
	}
	
	@Autowired
	public void setCustomerService (CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@Autowired
	public void setCustomerToCustomerDto (CustomerToCustomerDto customerToCustomerDto) {
		this.customerToCustomerDto = customerToCustomerDto;
	}
	
	
	// read all customers, no account info
	@RequestMapping(method = RequestMethod.GET, value = "api/customer", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CustomerDto>> listCustomers() {
		List<CustomerDto> list = customerToCustomerDto.convert (customerService.list ());
		return new ResponseEntity<> (list, HttpStatus.OK);
	}
	
	// read a specific customer
	@RequestMapping(method = RequestMethod.GET, value = "api/customer/{id}")
	public ResponseEntity<CustomerDto> customerById (@PathVariable Integer id) {
		CustomerDto customer = customerToCustomerDto.convert (customerService.get (id));
		return new ResponseEntity<> (customer, HttpStatus.OK);
	}
	
	// read all accounts for customer
	/*
	@RequestMapping(method = RequestMethod.GET, value = "api/customer/{id}/account")
	public ResponseEntity<List<AccountDto>> listAccounts() {
		
		List<AccountDto> list = accountToAccountDto.convert (accountService.)
	}
	*/
}
