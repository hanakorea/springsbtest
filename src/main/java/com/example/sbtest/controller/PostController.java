package com.example.sbtest.controller;



import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
//	게시물 보이게 + indexpost에	
	@GetMapping("/indexpost")
	public String indexPost(Model model, @PageableDefault(size=5, sort="id", direction = Direction.DESC) Pageable pageable) {
		Page<Board> postlist = postService.postlist(pageable);
		model.addAttribute("postlist",postlist);
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

//// 내가 올린 게시물만 보이게..완성 x
//	@GetMapping("/mypost")
//	public String myPost(HttpSession session, Model model) {
//		UserInfo user = (UserInfo) session.getAttribute("principal");
//		
//		return "user/mypost";
//	}
	
//	게시물 수정	
	@GetMapping("/modifypost")
	public String modifypost() {
		return "post/modifypost";
	}
}
