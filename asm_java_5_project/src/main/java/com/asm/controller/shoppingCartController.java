package com.asm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asm.model.cart_item;
import com.asm.model.product;
import com.asm.model.shopping_cart;
import com.asm.service.CartItemService;
import com.asm.service.ProductsService;
import com.asm.service.ShoppingCartService;

@Controller
@RequestMapping(value = "cart")
public class shoppingCartController {
	
	@Autowired
	CartItemService cartItemService;
	@Autowired
	ProductsService productsService;
	@Autowired 
	ShoppingCartService cartService;
	
	@GetMapping("")
	public String shoppingCartForm(Model model) {
		List<cart_item> list = cartItemService.selectByCurrentUser();
		model.addAttribute("list", list);
		return "user/shoppingCart";
	}
	
	
	@PostMapping("/add")
	@ResponseBody
	public String addToCart(@RequestParam("productId") String productID, @RequestParam("quantity") Integer quantity  ) {
		Optional<product> product= productsService.FindById(productID);
		product product2 =  product.orElse(new product());
		shopping_cart shopping_cart = cartService.selectByCurrentUser();
		
		cart_item cart_item = new cart_item(); 
		
		cart_item.setProduct(product2);
		cart_item.setShopping_cart(shopping_cart);
		cart_item.setQuantity(quantity);
		cartItemService.Create(cart_item);
		return "Thêm Vào Giỏi Hàng Thành Công";
	}
	
	@PostMapping("/remove")
	@ResponseBody
	public String removeCartItem(@RequestParam("cartItemId") Integer cartItemId) {
		cart_item cart_item  = cartItemService.selectById(cartItemId);
		System.out.println(cartItemId);
		if(cart_item != null) {
			cartItemService.Remove(cart_item);
			System.out.println("Thanh cong");
		}else {
			System.out.println("NUll");
		}
		return "Xoa Thanh Cong";
	}
	
}
