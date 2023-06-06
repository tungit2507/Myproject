package 
com.asm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asm.model.product;
import com.asm.model.product_category;
import com.asm.repository.productCategoryRepository;
import com.asm.repository.productRepository;

@Controller
public class HomeController {

	@Autowired
	productCategoryRepository categoryRepository;
	@Autowired
	productRepository productRepository;
	
	@RequestMapping("/index")
	public String index(Model model) {
		List<product_category> list = categoryRepository.findAll();
		List<product> listProduct = productRepository.findAll();
		model.addAttribute("list", list);
		model.addAttribute("listProduct", listProduct);
		return "user/index";
	}
	@GetMapping("/")
	public String getIndex() {
		return "redirect:index";
	}
}
