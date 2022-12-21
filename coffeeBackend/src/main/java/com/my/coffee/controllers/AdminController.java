package com.my.coffee.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.coffee.entities.Product;
import com.my.coffee.services.ProductService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    ProductService productService;

    public AdminController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product/add")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        try {
            productService.saveProduct(product);
            return new ResponseEntity<Product>(product, HttpStatus.OK);

     	} catch (Exception e) {
             return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }
    @DeleteMapping("/product/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable ("id") Long id){
		try {
			productService.deleteProduct(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch ( Exception e ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable ("id") Long id , @RequestBody Product product){
		try {
			productService.updateProduct(id , product);
			return new ResponseEntity<>(product , HttpStatus.OK);
		}catch ( Exception e ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

    @GetMapping ("/all")
	public ResponseEntity<List<Product>> getAllProducts() {
		try {
			List<Product> products = new ArrayList<Product>();
			products = productService.getAllProducts();
			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}	
			return new ResponseEntity<>(products, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable ("id") Long id ){
		try {
			Product product = productService.getProductById(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);

		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}


}
