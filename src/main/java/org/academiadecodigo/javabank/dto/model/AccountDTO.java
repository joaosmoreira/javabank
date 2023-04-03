package org.academiadecodigo.javabank.dto.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AccountDTO {
	
	private Integer id;
	
	@NotNull (message = "account type is mandatory")
	@NotBlank (message = "account type is mandatory")
	private String AccountType;
	
	/* min value? */
	@NotNull (message = "initial amount is mandatory")
	@NotBlank (message = "initial amount is mandatory")
	private String balance;
	
	public Integer getId () {
		return id;
	}
	
	public void setId (Integer id) {
		this.id = id;
	}
	
	public String getAccountType () {
		return AccountType;
	}
	
	public void setAccountType (String accountType) {
		AccountType = accountType;
	}
	
	public String getBalance () {
		return balance;
	}
	
	public void setBalance (String balance) {
		this.balance = balance;
	}
}
