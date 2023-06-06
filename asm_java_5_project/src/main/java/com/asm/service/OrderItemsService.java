package com.asm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.asm.model.orders_items;

@Service
public interface OrderItemsService {
	public 	List<orders_items> selectAll();
	public	orders_items 		Create(orders_items orders_items);	
	public 	orders_items 		Update(orders_items orders_items);
	public 	orders_items 		Remove(orders_items orders_items);
}
