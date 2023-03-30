package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControlEverything {
	
	public CustomerService customerService;
	
	
	@Autowired
	public void setCustomerService (CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String getCustomers(Model model){
		
		
		model.addAttribute ("customers", customerService.findAll());
		
		return "index";
		
	}


	
}
