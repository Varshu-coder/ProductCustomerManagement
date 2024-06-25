package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerRepository;
import com.exception.CustomerNotFoundException;
import com.model.Customer;


@Service
public class CustomerServiceImpl implements CustomerService  {
	@Autowired
	CustomerRepository customerRepo;

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepo.save(customer);
	}

	@Override
	public Customer getOne(int id) {
		// TODO Auto-generated method stub
		return customerRepo.findById(id).orElse(null);
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

}
