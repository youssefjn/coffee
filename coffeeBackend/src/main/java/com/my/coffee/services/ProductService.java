package com.my.coffee.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.my.coffee.entities.Product;
import com.my.coffee.exceptions.NotFoundExeception;
import com.my.coffee.repositories.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepository;


	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;

	}

	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}

	public Product getProductById(Long id) {
		Product product = productRepository.findById(id).orElseThrow(()-> 
		new NotFoundExeception("Product with id "+ id + " does not exist"));
		return product;
	}

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

	public void deleteProduct(Long id) {
		if ( !productRepository.existsById(id)) {
			throw new NotFoundExeception("id " + id +" doesn't exist");}
		productRepository.deleteById(id);
	}
	@Transactional
	public Product updateProduct (Long id , Product product) {
		Optional<Product> productData = Optional.of(productRepository.findById(id).orElseThrow(()-> new NotFoundExeception("product with id "+ id + " does not exist")));;

		if (productData.isPresent()) {
			Product _product = productData.get();
			if ( product.getName() != null && product.getName().length()> 0)
			_product.setName(product.getName());
			if (product.getLongDesc() != null && product.getLongDesc().length()> 0)
			_product.setLongDesc(product.getLongDesc());
			if (product.getShortDesc() != null && product.getShortDesc().length()> 0)
			_product.setShortDesc(product.getShortDesc());
			if (product.getPrice() != null )
			_product.setPrice(product.getPrice());
				return _product;
				}
		return null;
				
		
	
	}
}