package com.thoughtbend.wiredcoffee.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.thoughtbend.wiredcoffee.model.Customer;
import com.thoughtbend.wiredcoffee.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService = null;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getCustomers(WebRequest request) {
		
		LOGGER.info("Web request for all customers");
		
		ModelAndView result = new ModelAndView("customer-list");
		
		List<Customer> customerList = this.customerService.getCustomers();
		
		result.addObject("customerList", customerList);
		
		return result;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView getCustomer(@PathVariable Long id) {
		
		ModelAndView result = new ModelAndView("customer-detail");
		
		return result;
	}
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.POST)
	public ModelAndView deleteCustomer(@PathVariable Long id) {
		
		ModelAndView result = new ModelAndView("customer-list");
		
		this.customerService.deleteCustomer(id);
		List<Customer> customerList = this.customerService.getCustomers();
		
		result.addObject("customerList", customerList);
		
		result.addObject("successMessage", "Successfully deleted customer " + id);
		
		return result;
	}
}
