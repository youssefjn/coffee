package com.my.coffee.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.coffee.entities.ApiResponse;
import com.my.coffee.entities.Product;
import com.my.coffee.services.ProductService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {
    ProductService productService;

    public AdminController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/product/add")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
       
            productService.saveProduct(product);
            return new ResponseEntity<Product>(product, HttpStatus.OK);

     	
    }
    @DeleteMapping("/product/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable ("id") Long id){
		
			productService.deleteProduct(id);
			return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable ("id") Long id , @RequestBody Product product){
		
			productService.updateProduct(id , product);
			return new ResponseEntity<>(product , HttpStatus.OK);
		
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

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable ("id") Long id ){
	
			Product product = productService.getProductById(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);

		
	}


}
