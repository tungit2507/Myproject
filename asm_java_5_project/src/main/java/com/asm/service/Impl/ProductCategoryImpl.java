package com.asm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.model.product_category;
import com.asm.repository.productCategoryRepository;
import com.asm.service.ProductCategoryService;


@Service 
 
public class ProductCategoryImpl implements ProductCategoryService {
	@Autowired
	productCategoryRepository category;
	@Override
	public List<product_category> selectAll() {
		List<product_category> list = category.findAll();
		return list;
	}

	@Override
	public product_category Create(product_category product_category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public product_category Update(product_category product_category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public product_category Remove(product_category product_category) {
		// TODO Auto-generated method stub
		return null;
	}

}
