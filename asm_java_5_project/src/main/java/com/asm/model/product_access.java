package com.asm.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class product_access {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private 	Integer 	review_id;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private 	product 		product;// connect to product 
	@ManyToOne
	@JoinColumn(name = "username")
	private 	users 		users ;// connect to user
	@Temporal(TemporalType.DATE)
	private 	Date 		date_create;
	private 	String 		content;
	private 	Integer 	start_rate;
}
