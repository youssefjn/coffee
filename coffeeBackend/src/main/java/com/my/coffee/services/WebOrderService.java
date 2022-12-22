package com.my.coffee.services;

import org.springframework.stereotype.Service;

import com.my.coffee.entities.WebOrder;
import com.my.coffee.repositories.WebOrderRepository;

@Service
public class WebOrderService {
private WebOrderRepository webOrderRepository;
    public WebOrder saveOrder(WebOrder webOrder) {
        return webOrderRepository.save(webOrder);
    }
    
}
