package com.asm.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class product_discount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private 		Integer 			id;
	private 		Double 			discount_percent;
	private 		String 			imageurl;
	private			Boolean 		isactive;
	@OneToMany(mappedBy = "discount")
	List<product> listProduct;
}
