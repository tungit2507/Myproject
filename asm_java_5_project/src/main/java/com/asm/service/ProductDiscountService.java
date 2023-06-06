package com.asm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.asm.model.product_discount;


@Service
public interface ProductDiscountService {
	public 	List<product_discount> selectAll();
	public	product_discount 		Create(product_discount product_discount);	
	public 	product_discount 		Update(product_discount product_discount);
	public 	product_discount 		Remove(product_discount product_discount);
}
