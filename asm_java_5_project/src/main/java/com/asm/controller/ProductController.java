package com.asm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asm.model.product;
import com.asm.model.product_category;
import com.asm.service.ProductCategoryService;
import com.asm.service.ProductsService;

@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductsService productService;
	@Autowired
	ProductCategoryService categoryService;
	
	@GetMapping("")
	public String productForm(Model model, @RequestParam("category_id") Optional<String> category_id) {
		String id = category_id.orElse("Trống");
		if(id.equals("Trống")) {
			List<com.asm.model.product> list = productService.selectAll();
			model.addAttribute("list",list);
		}else {
			List<product> list= productService.selectByCategoryId(id);
			model.addAttribute("list",list);
		
		}
		
		List<product_category> listCategory = categoryService.selectAll();
		model.addAttribute("listCategory", listCategory);
		return "user/product";
	}
	
}
