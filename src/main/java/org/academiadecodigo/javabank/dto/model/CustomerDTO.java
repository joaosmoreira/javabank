package org.academiadecodigo.javabank.dto.model;

import javax.validation.constraints.*;

public class CustomerDTO {
	
	private Integer id;
	
	@NotNull (message = "first name is mandatory")
	@NotBlank (message = "first name is mandatory")
	@Size (min=3, max=64)
	private String firstName;
	
	@NotNull (message = "last name is mandatory")
	@NotBlank (message = "last name is mandatory")
	@Size (min=3, max=64)
	private String lastName;
	
	@Email
	private String email;
	
	@Pattern (regexp = "^\\+?[0-9]*$", message = "phone has invalid characters")
	@Size (min = 9, max = 16)
	private String phone;
	
	public Integer getId () {
		return id;
	}
	
	public void setId (Integer id) {
		this.id = id;
	}
	
	public String getFirstName () {
		return firstName;
	}
	
	public void setFirstName (String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName () {
		return lastName;
	}
	
	public void setLastName (String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail () {
		return email;
	}
	
	public void setEmail (String email) {
		this.email = email;
	}
	
	public String getPhone () {
		return phone;
	}
	
	public void setPhone (String phone) {
		this.phone = phone;
	}
}
