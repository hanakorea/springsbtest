package com.example.sbtest.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sbtest.domain.ResponseDTO;
import com.example.sbtest.domain.UserInfo;
import com.example.sbtest.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	회원가입 구현 부
	
	@GetMapping("/insertuser")
	public String insertuser() {
		return "user/insertuser";
	}
	
	
	// 아이디 중복 확인 버튼(값 입력시 알아서 확인) + alert 변경 필요
	// responseDTO이용 + js로 응답/페이지 이동
	@PostMapping("/insertuser")
	public String insertuser(UserInfo user) {
		UserInfo checkUser = userService.checkUser(user.getUsername());
		
		if(checkUser.getUsername() == null) {
			userService.insertUser(user);
			return "redirect:/";
		}else {
			return "user/insertuser";	
		}
	}
	
//	 로그인 구현 부
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	// 회원x, 로그인 성공, 로그인 실패 띄워주기
	@PostMapping("/login")
	public String login(UserInfo user, HttpSession session) {
		UserInfo checkUser = userService.checkUser(user.getUsername());
		
		if(checkUser.getUsername()==null) {
			return "redirect:/insertuser";
		}else {
			if(checkUser.getPassword().equals(user.getPassword())) {
				session.setAttribute("principal", checkUser);
				return "redirect:/";
			}else {
				return "redirect:/login";
			}
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
//	회원정보 수정 구현 부
	@GetMapping("/userinfo")
	public String userinfo(HttpSession session, Model model) {
		UserInfo user = userService.userFind(session);
		model.addAttribute("userinfo", user);
		return "user/userinfo";
	}
	
	@PostMapping("/userinfo")
	public String userinfo(HttpSession session, UserInfo userinfo, Model model) {
		UserInfo user = userService.userUpdate(session, userinfo);
		model.addAttribute("userinfo", user);
		session.setAttribute("principal", user);
		return "redirect:/userinfo";
	}
	
	
// 	회원 탈퇴 구현 부
	
	// 왜 object로 페이지에 나타나는가...?
	@DeleteMapping("/delete")
	@ResponseBody
	public ResponseDTO<?> delete(int id, HttpSession session) {
		userService.delete(id);
		session.invalidate();
		return new ResponseDTO<>(HttpStatus.OK.value(),"탈퇴 성공");
	}
}
