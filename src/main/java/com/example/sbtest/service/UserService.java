package com.example.sbtest.service;


import javax.servlet.http.HttpSession;

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
	public UserInfo checkUser(String username) {
		UserInfo check= userRepository.findByUsername(username).orElseGet(()->{
			return new UserInfo();
		});
		return check; 
	}
	
	// 정보찾아서 수정
	public void userUpdate(HttpSession session, UserInfo user) {
		UserInfo user
		
		UserInfo userFind = userRepository.findById(id).get();
		userFind.setPassword(user.getPassword());
		userFind.setEmail(user.getEmail());
		userRepository.save(userFind);
	}
	
	// 계정삭제
	public void delete(int id) {
		userRepository.deleteById(id);
	}

}
