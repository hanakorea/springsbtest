package com.example.sbtest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sbtest.domain.UserInfo;
import com.example.sbtest.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	// db에 저장
	public void insertUser(UserInfo user) {
		userRepository.save(user);
	}
	
	// username 중복 검사
	public Optional<UserInfo> checkUser(String username) {
		Optional<UserInfo> check= userRepository.findByUsername(username);
		
		return check;
	}
	

}
