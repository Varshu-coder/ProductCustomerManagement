package com.service;

import java.util.List;
import java.util.Map;

import com.exception.CustomerNotFoundException;
import com.model.Customer;

public interface CustomerService {
	public Customer addCustomer (Customer customer);
	
	public Customer getOne(int id);
	
	public List<Customer> getAllCustomer();
	
	
	

}
