package com.asm.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.constant.sessionAttribute;
import com.asm.model.cart_item;
import com.asm.model.users;
import com.asm.repository.cartItemRepository;
import com.asm.service.CartItemService;

import jakarta.servlet.http.HttpSession;

@Service
public class cartItemServiceImpl implements CartItemService {

	@Autowired
	cartItemRepository cartItemRepository;
	@Autowired 
	HttpSession httpSession;
	
	@Override
	public List<cart_item> selectAll() {
		return cartItemRepository.findAll();
	}

	@Override
	public cart_item Create(cart_item cart_item) {
		cart_item cart_item2 =  cartItemRepository.findByProductAndShoppingCart(cart_item.getProduct(), cart_item.getShopping_cart());
		if(cart_item2 == null) {
			cartItemRepository.save(cart_item);
		}else {
			cart_item2.setQuantity(cart_item2.getQuantity() + cart_item.getQuantity());
			Update(cart_item2);
		}
		return cart_item;
	}

	@Override
	public cart_item Update(cart_item cart_item) {
		if(cart_item.getQuantity() <= 0) {
			Remove(cart_item);
		}else {
			cartItemRepository.save(cart_item);
		}
		return cart_item;
	}

	@Override
	public cart_item Remove(cart_item cart_item) {
		cartItemRepository.delete(cart_item);
		return cart_item;
	}

	@Override
	public List<cart_item> selectByCurrentUser() {
		users users = (com.asm.model.users) httpSession.getAttribute(sessionAttribute.CURRENT_USER);
		List<cart_item> list  = cartItemRepository.findByCurrentUser(users);
		return list;
	}

	@Override
	public cart_item selectById(Integer cartItemId) {
		Optional<cart_item> item = cartItemRepository.findById(cartItemId);
		return item.orElse(null);
	}


	
}
