package com.my.coffee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.coffee.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}