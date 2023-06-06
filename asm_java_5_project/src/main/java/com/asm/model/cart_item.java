package com.asm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class cart_item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private 	Integer 	id;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private 	product 		product;// foreign key connect to product id
	@ManyToOne
	@JoinColumn(name = "shopping_cart_id")
	private 	shopping_cart 	shopping_cart;// foreign key connect to shopping cart id 
	private 	Integer 	quantity;
}

