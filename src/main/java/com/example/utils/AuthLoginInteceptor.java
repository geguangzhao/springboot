package com.example.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.bean.User;
import com.example.service.UserService;

public class AuthLoginInteceptor extends  HandlerInterceptorAdapter {

		@Autowired
	    UserService userInfoService ;

	   @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
			HandlerMethod method =(HandlerMethod) handler;
			AuthLoginAnnotation auth =method.getMethodAnnotation(AuthLoginAnnotation.class);
			if(auth !=null&&auth.check()) {
				User user =(User) request.getSession().getAttribute("user");
				if(user==null) {
					response.sendRedirect("/login/loginIndex");
					return false;
				}
				throw new BadRequestException("");
			}
			
		   return true;
	    }
	   //请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
	    @Override
	    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
	        
	    }
	 
	    //在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
	    @Override
	    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
	        
	    }
}
