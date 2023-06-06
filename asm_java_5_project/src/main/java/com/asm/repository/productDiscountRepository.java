package com.asm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asm.model.product_discount;
@Repository
public interface productDiscountRepository extends JpaRepository<product_discount, Integer>{
	
}
