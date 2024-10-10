package com.example.sbtest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sbtest.domain.Board;
import com.example.sbtest.domain.UserInfo;
import com.example.sbtest.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/insertpost")
	public String insertpost() {
		return "post/insertpost";
	}
	
	@PostMapping("/insertpost")
	public String insertpost(Board board, HttpSession session) {
		UserInfo user = (UserInfo)session.getAttribute("principal");
		postService.insertpost(board, user);
		
		return "redirect:/";
	}
}
