package com.crud.service;

import java.util.*;
import java.util.Optional;
import java.lang.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Product;
import com.crud.reposiotry.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	
	public Product saveProduct(Product product ) {
		return productRepository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products ) {
		return productRepository.saveAll(products);
	}
	
	public List<Product> getProduct(){
		return productRepository.findAll();
	}
	
	public Optional<Product> getProductById(int id){
		return productRepository.findById(id);
	}
	
	public Product getProductByName(String name) {
		return productRepository.findByName(name);
	}
	
	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return "product deleted !!"+id;
	}
	
	public Product updateProduct(Product product) {
	Product product2=productRepository.findById(product.getId()).orElse(null);
	product2.setName(product.getName());
	product2.setPrice(product.getPrice());
	product2.setQuantity(product.getQuantity());
	return productRepository.save(product2);
	
	}
		
		
	}
	
	

