package com.asm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asm.model.product_access;
@Repository
public interface productAssessRepository extends JpaRepository<product_access, Integer>{
	
}
