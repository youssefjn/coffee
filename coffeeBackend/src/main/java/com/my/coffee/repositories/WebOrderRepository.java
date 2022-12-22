package com.my.coffee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.coffee.entities.WebOrder;

public interface WebOrderRepository extends JpaRepository<WebOrder,Long> {
    
}
