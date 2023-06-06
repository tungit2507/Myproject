package com.asm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asm.model.product;
import com.asm.model.product_category;
import com.asm.service.ProductsService;

@Controller
@RequestMapping("productdetail")
public class ProductDetailController {
	@Autowired
	ProductsService productService;
	@GetMapping("")
	public String productForm(Model model, @RequestParam("productid") String id) {
		Optional<product> Oproduct = productService.FindById(id);
		product product = Oproduct.orElse(new product());
		model.addAttribute("product",product);
		return "user/product_detail";
	}	
}
