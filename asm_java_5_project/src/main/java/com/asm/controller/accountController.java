package com.asm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asm.constant.sessionAttribute;
import com.asm.dto.userLogin;
import com.asm.model.users;
import com.asm.service.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("account")
public class accountController {
	@Autowired
	UsersService usersService;
	@Autowired
	HttpSession session;
	
	@GetMapping("login")
	public String Login() {
		return "user/login";
	}
	
	@PostMapping("login")
	public String loginPost(Model model,@RequestParam("username") String username, @RequestParam("password") String password) {
		userLogin account  = new userLogin(username,password);
		Boolean request  = usersService.Login(account);
		if(request == false) {
			model.addAttribute("message", "Sai Tên Tài Khoản Hoặc Mật Khẩu");
			return "user/login";
		}else {
			return "redirect:../index";
		}
	}
	
	@GetMapping("signUp")
	public String SignUp() {
		return "user/SignUp";
	}
	
	@PostMapping("signUp")	
	public String SignUpPost() {
		return "user/fillOTP";
	}
	
	@GetMapping("changePassword")
	public String changePassword() {
		return "user/changePass";
	}
	
	@PostMapping("changePassword")
	public String changePasswordPost(Model model, @RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword,  @RequestParam("confirmPassword") String confirmPassword ) {
		users users = (com.asm.model.users) session.getAttribute(sessionAttribute.CURRENT_USER);
		if(users.getPassword().equals(oldPassword)) {
			if(newPassword.equals(confirmPassword)) {
				users.setPassword(confirmPassword);
				usersService.Update(users);
				session.setAttribute(sessionAttribute.CURRENT_USER, users);
				return  "redirect:../index";
			}else {
				model.addAttribute("message","Vui Lòng Xác Nhận Lại Mật khẩu");
				return "user/changePass";
			}
		}else {
			model.addAttribute("message","Sai Mật Khẩu Hiện Tại");
			return "user/changePass";
		}
	}
	
	
	@GetMapping("logOut")
	public String logOut() {
		session.setAttribute(com.asm.constant.sessionAttribute.CURRENT_USER, null);
		return  "redirect:../index";
	}
}
