package com.asm.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class users {
	@Id
	private 		String 			username;
	private 		String 			password;
	private 		String 			fullname;
	private 		String 			adress;
	private 		String 			phone_number;
	private 		String 			email;
	private 		String 			photo;
	@Temporal(TemporalType.DATE)
	private 		Date 			createdate;
	private 		Boolean 		isadmin;
	private 		Boolean 		isactive;
	
	@OneToMany(mappedBy = "users")
	private List<product> listProduct;
	@OneToMany(mappedBy = "users")
	private List<product_access> listProductAsess;
	@OneToMany(mappedBy = "users")
	List<shopping_cart> listShoppingCart;
	@OneToMany(mappedBy = "users")
	List<orders> listOrders;
}
