package com.asm.service;

import java.util.List;

import com.asm.model.orders;

public interface OrdersService {
	public 	List<orders>	selectAll();
	public	orders 			Create(orders orders);	
	public 	orders 			Update(orders orders);
	public 	orders 			Remove(orders orders);
}
