package com.my.coffee.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.coffee.entities.WebOrder;
import com.my.coffee.services.WebOrderService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/order")
public class WebOrderController {
    private WebOrderService webOrderService;
    
    public WebOrderController(WebOrderService webOrderService) {
        this.webOrderService = webOrderService;
    }

    @PostMapping
    public ResponseEntity<WebOrder> saveOrder(@RequestBody WebOrder webOrder){
    

            return new ResponseEntity<WebOrder>(webOrderService.saveOrder(webOrder),HttpStatus.OK);

        
    }
    
}
