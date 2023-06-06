package com.asm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asm.model.shopping_cart;
import com.asm.model.users;
@Repository
public interface shoppingCartRepository extends JpaRepository<shopping_cart, Integer>{
	shopping_cart findByUsers(users users);
}
