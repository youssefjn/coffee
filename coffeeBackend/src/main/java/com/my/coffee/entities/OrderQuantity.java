package com.my.coffee.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "order_quantity")
@Data
public class OrderQuantity {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;
    int quantity;
    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;
    @ManyToOne
    @JoinColumn(name = "web_order_id")
    WebOrder webOrder;

}
