package com.asm.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class shopping_cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private 		Integer 		id;
	@ManyToOne
	@JoinColumn( name = "username")
	private 		users 			users;
	@Temporal(TemporalType.DATE)
	private 		Date 			createdate;
	
	@OneToMany(mappedBy = "shopping_cart")
	List<cart_item> listCartItem;
}
