package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.bean.User;
import com.example.service.UserService;
import com.example.utils.AuthLoginAnnotation;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/userIndex")
	public ModelAndView userIndex(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mov = new ModelAndView();
		try {
			
			mov.setViewName("user/userIndex");
		}
		catch(Exception ex) {
			
		}
		return mov;
	}
	
	@RequestMapping("/list")
	@AuthLoginAnnotation(check=true)
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,User user) {
		
		ModelAndView mov = new ModelAndView();
		try {
			List<User> list =this.userService.queryUserList(user);
			mov.setViewName("user/userIndex");
			mov.addObject("list", list);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return mov;
	}
}
