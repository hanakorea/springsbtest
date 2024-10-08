package com.example.sbtest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sbtest.domain.UserInfo;
import com.example.sbtest.service.UserService;

@Controller
public class UserController {
	
	@GetMapping("/insertuser")
	public String insertuser() {
		return "user/insertuser";
	}
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/insertuser")
	public String insertuser(UserInfo user) {
		Optional<UserInfo> check = userService.checkUser(user.getUsername());
		
		if(check == null) {
			userService.insertUser(user);
			
			return "redirect: /";
		}else {
			return "redirect:/insertuser";
		}
		
	}
}
