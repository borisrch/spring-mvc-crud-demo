package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// Inject CustomerService
	@Autowired
	private CustomerService customerService;
	
	// Uses Http Get
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// Get Customers from DAO
		List<Customer> theCustomers = customerService.getCustomers();
		
		// Add Customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// Create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// Sets up mapping for post, linking model attribute, then redirect.
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	// CustomerService <--> CustomerDAO <--> Hibernate
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		// Get customer from the CustomerService.
		Customer theCustomer = customerService.getCustomer(theId);
				
		// Set customer as a model attribute to pre-populate the form.
		theModel.addAttribute("customer", theCustomer);
				
		// Send over to our form.
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		//Delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	
}
