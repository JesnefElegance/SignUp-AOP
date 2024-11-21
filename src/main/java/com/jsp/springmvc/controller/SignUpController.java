package com.jsp.springmvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsp.springmvc.service.SignUpService;

@Controller
public class SignUpController {
	
	@Autowired
	private SignUpService service;

	@RequestMapping("/signUp")
	public void signUp(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		boolean flag = (boolean)req.getAttribute("flag");
		
		if(flag) {
						
		int userId = Integer.parseInt(req.getParameter("userId"));
		String userName = req.getParameter("userName");
		String userEmail = req.getParameter("userEmail");
		String userPassword = req.getParameter("userPassword");
		
		String response = service.signUp(userId, userName, userEmail, userPassword);
		
		String mes = (String)req.getAttribute("message");
		System.out.println(mes);
		req.setAttribute("response", response);
		RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
		rd.forward(req, res);
		}
	}
}
