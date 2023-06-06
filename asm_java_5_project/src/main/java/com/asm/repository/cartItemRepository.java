package com.asm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asm.model.cart_item;
import com.asm.model.product;
import com.asm.model.shopping_cart;
import com.asm.model.users;
@Repository
public interface cartItemRepository extends JpaRepository<cart_item, Integer>{
	@Query(value = "select o from cart_item o where o.shopping_cart.users =?1")
	public List<cart_item> findByCurrentUser(users users);
	@Query(value ="select o from cart_item o where o.product =?1 and o.shopping_cart = ?2")
	public cart_item findByProductAndShoppingCart(product product, shopping_cart shopping_cart);
}
