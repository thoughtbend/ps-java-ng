package com.thoughtbend.wiredcoffee.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.thoughtbend.wiredcoffee.model.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getCustomers(WebRequest request) {
		
		ModelAndView result = new ModelAndView(/*"/WEB-INF/pages/customer-list.jsp"*/"customer-list");
		
		List<Customer> customerList = new ArrayList<>();
		
		Customer customer1 = new Customer();
		customer1.setId(123L);
		customer1.setFirstName("Mike");
		customer1.setLastName("Nolan");
		
		Customer customer2 = new Customer();
		customer2.setId(234L);
		customer2.setFirstName("Jim");
		customer2.setLastName("Jones");
		
		customerList.add(customer1);
		customerList.add(customer2);
		
		result.addObject("customerList", customerList);
		
		return result;
	}
}
