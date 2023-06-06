package com.asm.model;


import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
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
public class product {
	@Id
	private 	String 			id;
	private 	String 			names;
	private 	Double 			price;
	private 	String 			images;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private 	product_category 		category;//foreign key connect to product_category
	private 	String 			descriptions;
	@ManyToOne
	@JoinColumn(name = "create_by")
	private 	users 			users;//foreign key connect to user
	@ManyToOne
	@JoinColumn(name = "discount_id")
	private 	product_discount		discount;//foreign key connect to product_discount
	private 	Boolean 		isactive;
	@Temporal(TemporalType.DATE)
	private 	Date 			create_date;
	@OneToMany(mappedBy = "product")
	List<product_access> listProductAccess;
	@OneToMany(mappedBy = "product")
	List<cart_item> listCartItem;
	@OneToMany(mappedBy = "product")
	List<orders_items> listOrderItem;
	
}
 