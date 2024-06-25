package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProductRepository;
import com.exception.ProductNotFoundException;
import com.model.Product;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;
	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}
	@Override
	public Product getOne(int id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).orElse(null);
	}
	@Override
	public List<Product> getAllProduct() {
		
		return productRepo.findAll();
	}
	@Override
	public Map<String, Object> deleteProduct(int id) throws ProductNotFoundException{
		Map<String,Object> response=new HashMap<String,Object>();
		try {
		Product product=productRepo.findById(id).orElseThrow(()->new ProductNotFoundException("schem not exist"+id));
		productRepo.delete(product);
		response.put("deleted",Boolean.TRUE);
		}catch(ProductNotFoundException p)
		{
			response.put("not deleted", p.getMessage());
		}
		return response;
	}

}
