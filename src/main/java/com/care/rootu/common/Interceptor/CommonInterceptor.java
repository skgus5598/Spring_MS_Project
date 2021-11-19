package com.care.rootu.common.Interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor extends HandlerInterceptorAdapter{
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("로그인 세션 확인 인터셉터 실행!");
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script> alert('로그인 먼저 해주세요'); "
					+ "location.href=' "+request.getContextPath()+"/login'; </script>");
			return false; //사용자가 요청한 경로로 연결하지 않겠다.
		}		
		return true; // 사용자가 요청한 컨트롤러로 연결하겠다 
	}

}
