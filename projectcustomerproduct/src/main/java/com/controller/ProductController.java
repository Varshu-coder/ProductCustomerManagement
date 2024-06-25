package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Product;
import com.service.ProductService;
@CrossOrigin(origins="http://localhost:4200/")
@RestController
@RequestMapping("/p")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		Product p=productService.addProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).header("add", "Save Product").body(p);
	}
	
	@GetMapping("/getOne/{id}")
	public Product getOneProduct(@PathVariable("id")int id)
	{
		return productService.getOne(id);
	}
	
	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct()
	{
		return productService.getAllProduct();
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<Map<String,Object>> deleteProduct(@PathVariable("id")int id) throws Exception
	{
		Map<String,Object> response=productService.deleteProduct(id);
		return ResponseEntity.ok(response);
	}
	
}
