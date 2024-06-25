package com.service;

import java.util.List;
import java.util.Map;

import com.exception.ProductNotFoundException;
import com.model.Product;

public interface ProductService {
	
	public Product addProduct (Product product);
	
	public Product getOne(int id);
	
	public List<Product> getAllProduct();
	
	public Map<String,Object> deleteProduct(int id) throws ProductNotFoundException,Exception;
	
	
	

}
