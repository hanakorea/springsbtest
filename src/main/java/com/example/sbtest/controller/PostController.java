package com.example.sbtest.controller;

import java.awt.print.Pageable;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sbtest.domain.Board;
import com.example.sbtest.domain.UserInfo;
import com.example.sbtest.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/indexpost")
	public String indexPost() {
		return "indexpost";
	}
//	게시물 등록	
	
	@GetMapping("/insertpost")
	public String insertpost() {
		return "post/insertpost";
	}
	
	@PostMapping("/insertpost")
	public String insertpost(Board board, HttpSession session) {
		System.out.println(board);
		UserInfo user = (UserInfo)session.getAttribute("principal");
		postService.insertpost(board, user);
		
		return "redirect:/indexpost";
	}
//	게시물 보이게
	@GetMapping("/indexpost")
	public void showPost(Model model,@PageableDefault(size=5, sort="id",direction=Direction.DESC)Pageable pageable) {
		Page<board> postlist = 
	}
	
	
	
//	게시물 수정	
	@GetMapping("/modifypost")
	public String modifypost() {
		return "post/modifypost";
	}
}
