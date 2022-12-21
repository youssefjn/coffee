package com.my.coffee.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name = "web_order")
@Data
public class WebOrder {
    @Id
	@GeneratedValue (strategy =GenerationType.IDENTITY )
    Long id;

    String name;

    String phoneNumber;

    LocalDateTime  date;

    String address;
    
    @OneToMany(mappedBy = "webOrder")
    Set<OrderQuantity> order_quantity;
}
