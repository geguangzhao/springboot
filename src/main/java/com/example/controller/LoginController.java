package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("/loginIndex")
	public ModelAndView loginIndex(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mov = new ModelAndView();
		try {
			
			mov.setViewName("login/loginIndex");
		}
		catch(Exception ex) {
			
		}
		return mov;
	}
}
