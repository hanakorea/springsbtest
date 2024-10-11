package com.example.sbtest.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.sbtest.domain.Board;
import com.example.sbtest.domain.UserInfo;
import com.example.sbtest.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired 
	private PostRepository postRepository;
	
	public void insertpost(Board board, UserInfo user) {
		board.setUser(user);
		postRepository.save(board);	
	}
	
	// 전체 게시물 찾기
	public Page<Board> postlist(Pageable pageable) {
		return postRepository.findAll(pageable);
	}
	
	
//	// 내가 올린 게시물만 보이게...완성x
//	public Page<Board> findPost(UserInfo user, Pageable pageable) {
//		Page<Board> post = postRepository.findByUserid(user.getId(), pageable);
//		return post;
//	}

}
