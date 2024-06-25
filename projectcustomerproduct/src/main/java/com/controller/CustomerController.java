package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Customer;
import com.service.CustomerService;
@CrossOrigin(origins="http://localhost:4200/")
@RestController
@RequestMapping("/c")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		Customer c=customerService.addCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).header("add", "Save Customer").body(c);
	}
	
	@GetMapping("/getOne/{id}")
	public Customer getOnecustomer(@PathVariable("id")int id)
	{
		return customerService.getOne(id);
	}
	
	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCustomer()
	{
		return customerService.getAllCustomer();
	}

}
