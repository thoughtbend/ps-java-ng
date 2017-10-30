package com.thoughtbend.wiredcoffee.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.thoughtbend.wiredcoffee.model.Customer;

@Component
public class CustomerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

	private static List<Customer> CUSTOMER_LIST_STORE = new ArrayList<>();

	static {
		Customer customer1 = new Customer();
		customer1.setId(123L);
		customer1.setFirstName("Mike");
		customer1.setLastName("Nolan");
		customer1.setEmail("mnolan@thoughtbend.com");

		Customer customer2 = new Customer();
		customer2.setId(234L);
		customer2.setFirstName("Jim");
		customer2.setLastName("Jones");
		customer2.setEmail("jjones@somecustomer.com");

		CUSTOMER_LIST_STORE.add(customer1);
		CUSTOMER_LIST_STORE.add(customer2);
	}

	public List<Customer> getCustomers() {

		return CUSTOMER_LIST_STORE;
	}

	public void deleteCustomer(final Long customerId) {

		synchronized (this) {
			LOGGER.info("Deleteing customer " + customerId);
			final List<Customer> newCustomerList = new ArrayList<>();
			CUSTOMER_LIST_STORE.stream().filter((customer) -> {
				return (customer.getId() == customerId);
			}).forEach((customer) -> {
				newCustomerList.add(customer);
			});

			CUSTOMER_LIST_STORE = newCustomerList;
		}
	}
}
