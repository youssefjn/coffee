package com.my.coffee.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.coffee.entities.Product;
import com.my.coffee.services.ProductService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/home")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	@GetMapping ("/all")
	public ResponseEntity<List<Product>> getAllProducts() {
		
			List<Product> products = new ArrayList<Product>();
			products = productService.getAllProducts();
			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}	
			return new ResponseEntity<>(products, HttpStatus.OK);
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable ("id") Long id ){
		
			Product product = productService.getProductById(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);

		
	}


}