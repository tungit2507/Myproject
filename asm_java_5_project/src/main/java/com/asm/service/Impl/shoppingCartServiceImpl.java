package com.asm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.constant.sessionAttribute;
import com.asm.model.shopping_cart;
import com.asm.model.users;
import com.asm.repository.shoppingCartRepository;
import com.asm.service.ShoppingCartService;

import jakarta.servlet.http.HttpSession;

@Service
public class shoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	shoppingCartRepository cartRepository;
	@Autowired
	HttpSession httpSession;
	
	@Override
	public List<shopping_cart> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public shopping_cart Create(shopping_cart shopping_cart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public shopping_cart Update(shopping_cart shopping_cart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public shopping_cart Remove(shopping_cart shopping_cart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public shopping_cart selectByCurrentUser() {
		users users = (com.asm.model.users) httpSession.getAttribute(sessionAttribute.CURRENT_USER);
		return (shopping_cart) cartRepository.findByUsers(users);
	}

}
