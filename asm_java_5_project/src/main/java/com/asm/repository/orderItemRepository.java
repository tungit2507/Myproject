package com.asm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asm.model.orders_items;
@Repository
public interface orderItemRepository extends JpaRepository<orders_items, Integer>{
	
}
