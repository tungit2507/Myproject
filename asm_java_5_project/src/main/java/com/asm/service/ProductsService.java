package com.asm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.asm.model.product;

@Service
public interface ProductsService {
	public 	List<product> selectAll();
	public	product 		Create(product product);	
	public 	product 		Update(product product);
	public 	product 		Remove(product product);
	public 	Optional<product> 		FindById(String id);
	public 	List<product> 		selectByCategoryId(String product_categoryId);
}	
