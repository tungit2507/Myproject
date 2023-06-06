package com.asm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.asm.model.cart_item;

@Service
public interface CartItemService {
	public 	List<cart_item> selectAll();
	public	cart_item 		Create(cart_item cart_item);	
	public 	cart_item 		Update(cart_item cart_item);
	public 	cart_item 		Remove(cart_item cart_item);
	public 	List<cart_item> selectByCurrentUser();
	public 	cart_item selectById(Integer cartItemId);
}
