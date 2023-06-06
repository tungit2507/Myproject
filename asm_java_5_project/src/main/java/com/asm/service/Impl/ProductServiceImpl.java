package com.asm.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.model.product;
import com.asm.repository.productRepository;
import com.asm.service.ProductsService;

@Service
public class ProductServiceImpl implements ProductsService {
	@Autowired
	productRepository productRepo;
	
	@Override
	public List<product> selectAll() {
		List<product> list = productRepo.findByIsactive(true);
		return list;
	}

	@Override
	public product Create(product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public product Update(product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public product Remove(product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<product> selectByCategoryId(String product_categoryId) {
		List<product> list = productRepo.findByCategoryId(product_categoryId);
		return list ;
	}

	@Override
	public Optional<product> FindById(String id) {
		Optional<product> propduct = productRepo.findById(id);
		return propduct;
	}
}
