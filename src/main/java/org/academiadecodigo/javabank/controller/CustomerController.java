package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.dto.DTOToCustomer;
import org.academiadecodigo.javabank.dto.model.CustomerDTO;
import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/list", "/", ""})
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.list());
        return "customer/list";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String showCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.get(id));
        model.addAttribute("recipients", customerService.listRecipients(id));
        return "customer/show";
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}/delete")
    public String deleteCustomer(@PathVariable Integer id) {
        customerService.delete(id);
        return "redirect:/customer/list";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{cid}/recipient/{rid}/delete/")
    public String deleteRecipient(@PathVariable Integer cid, @PathVariable Integer rid) {
        customerService.removeRecipient(cid, rid);
        return "redirect:/customer/" + cid;
    }
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public String addCustomer(@ModelAttribute Customer customer) {
        
        Customer savedCustomer = customerService.save(customer);
        
        return "redirect:/customer/" + savedCustomer.getId();
    }

    
    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public String saveCustomer(@ModelAttribute CustomerDTO customerDTO, RedirectAttributes redirectAttributes) {
    
        DTOToCustomer dtoToCustomer = new DTOToCustomer ();
        
        Customer savedCustomer = customerService.save (dtoToCustomer.converter (customerDTO));
        
        redirectAttributes.addFlashAttribute("lastAction", "Added customer successfully!");
        return "redirect:/customer/list";
        
    }
    
}
