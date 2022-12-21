package com.my.coffee.entities;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table (name = "product")
@Data

public class Product {
    @Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ;
	@NotBlank
	@Column(length = 255,name = "short_description")
	private String shortDesc;
	@NotBlank
	@Column(length = 255,name = "long_description")
	private String longDesc;
	@NotBlank
	@Column(length = 255)
	private String name;
	@NotNull
	@Column(length = 255)
	private Double price;
	@JsonIgnore
	@OneToMany(mappedBy = "product")
    Set<OrderQuantity> order_quantity;


}