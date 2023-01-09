package com.my.coffee.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.my.coffee.entities.WebOrder;
import com.my.coffee.repositories.WebOrderRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WebOrderService {
private WebOrderRepository webOrderRepository;
    public WebOrder saveOrder(WebOrder webOrder) {
        webOrder.setDate(new Date());
        return webOrderRepository.save(webOrder);
    }
    
}
