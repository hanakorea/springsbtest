package com.example.sbtest.service;


import org.springframework.beans.factory.annotation.Autowired;
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
}
