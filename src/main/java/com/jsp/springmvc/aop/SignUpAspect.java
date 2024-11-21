package com.jsp.springmvc.aop;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.jsp.springmvc.exception.EmailInvalidException;
import com.jsp.springmvc.exception.PasswordInvalidException;

@Aspect
@Component
public class SignUpAspect {

	@Before("execution(* signUp(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)) && args(req, res)")
	public void loginValidator(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		req.setAttribute("flag", true);
		
		System.out.println("Iam login validator");
		
		String userEmail = req.getParameter("userEmail");
		String userPassword = req.getParameter("userPassword");
		String confirmPassword = req.getParameter("confirmPassword");
		
		System.out.println(userEmail);
		System.out.println(userPassword);
		System.out.println(confirmPassword);
		try {
			
		if(emailValidator(userEmail)==false)
		{
			req.setAttribute("flag", false);
			throw new EmailInvalidException("Invalid Email");
		}
		if(passwordValidator(userPassword, confirmPassword)==false) {
			req.setAttribute("flag", false);
			throw new PasswordInvalidException("Invalid Password");
		}
		}catch(EmailInvalidException | PasswordInvalidException e)
		{
			req.setAttribute("message", e.getMessage());
			RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
			rd.forward(req, res);
			e.printStackTrace();
		}
		
	}
	public boolean emailValidator(String email) {
		int index = email.indexOf('@');
		String sub = email.substring(index+1);
		String[] validMails = {"gmail.com", "yahoo.com", "rediff,com"};
		
		for(String validMail: validMails)
		{
			if(validMail.equals(sub))
				return true;
		}
		return false;
		
	}
	public boolean passwordValidator(String userPassword, String confirmPassword) {
		if(userPassword.length()<8) return false;
		
		if(userPassword.equals(confirmPassword)) return true;
		
		return false;
	}
}
