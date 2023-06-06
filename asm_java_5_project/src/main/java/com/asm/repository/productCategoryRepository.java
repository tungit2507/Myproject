package com.asm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asm.model.product_category;
@Repository
public interface productCategoryRepository extends JpaRepository<product_category, Integer>{
	
}
