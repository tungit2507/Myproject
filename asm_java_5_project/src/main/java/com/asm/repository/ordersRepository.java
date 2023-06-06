package com.asm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asm.model.orders;
@Repository
public interface ordersRepository extends JpaRepository<orders, Integer>{
	
}
