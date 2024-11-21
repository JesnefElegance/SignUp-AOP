package com.jsp.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.springmvc.model.SignUp;
import com.jsp.springmvc.repository.SignUpRepository;

@Service
public class SignUpService {

	@Autowired
	private SignUp s;
	
	@Autowired
	private SignUpRepository repo;
	
	public String signUp(int userId, String userName, String userEmail, String userPassword) {
		
		s.setUserId(userId);
		s.setUserName(userName);
		s.setUserEmail(userEmail);
		s.setUserPassword(userPassword);
		
		return repo.signUp(s);
	}
}
