package com.asm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.asm.model.shopping_cart;

@Service
public interface ShoppingCartService {
	public 	List<shopping_cart> selectAll();
	public	shopping_cart 		Create(shopping_cart shopping_cart);	
	public 	shopping_cart 		Update(shopping_cart shopping_cart);
	public 	shopping_cart 		Remove(shopping_cart shopping_cart);
	public 	shopping_cart		selectByCurrentUser();
}
