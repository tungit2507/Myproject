package com.asm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asm.model.product;
import com.asm.model.product_category;
@Repository
public interface productRepository extends JpaRepository<product, String>{
	List<product> findByIsactive(Boolean isactive);
	List<product> findByCategory(product_category category);
	@Query( value = "select * from product where product.category_id = ?1", nativeQuery = true)
	List<product> findByCategoryId(String categoryId);
}
