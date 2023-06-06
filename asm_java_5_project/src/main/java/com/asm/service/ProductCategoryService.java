package com.asm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.asm.model.product_category;

@Service
public interface ProductCategoryService {
	public 	List<product_category> selectAll();
	public	product_category 		Create(product_category product_category);	
	public 	product_category 		Update(product_category product_category);
	public 	product_category 		Remove(product_category product_category);
}
