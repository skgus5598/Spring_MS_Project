package com.care.rootu.admin.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.rootu.admin.dto.AdminDTO;
import com.care.rootu.mybatis.admin.AdminMapper;

@Service
public class AdminService {
	@Autowired AdminMapper am;
	
	public void loginChk(String id, String pwd, HttpServletResponse response, HttpSession session) {
		AdminDTO dto = am.loginChk(id);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(dto != null) {
			if(pwd.equals(dto.getPassword())) {				
				session.setAttribute("loginUser", id);
				out.print("<script>location.href='home';</script>"); //로그인 성공 
			}else {
				out.print("<script>alert('비밀번호가 일치하지 않습니다.');"
						+ "location.href='login'; </script>");			
			}
		} else {
			out.print("<script>alert('존재하지 않는 아이디입니다.');"
					+ "location.href='login'; </script>");	
		}
	}
	
	public void createAcc(AdminDTO dto, String passwordChk, HttpServletResponse response) {
		
		PrintWriter out = null;
		response.setContentType("text/html; charset=utf-8");
		int result = 0;
		try {
			out = response.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!passwordChk.equals(dto.getPassword())) {
			out.print("<script>alert('비밀번호가 다릅니다');"
					+ "location.href='registerForm';</script>");
		}else {
			try {
				result = am.createAcc(dto);				
			} catch (Exception e) {
					e.printStackTrace();
			}
			if(result == 1) {
				out.print("<script>alert('회원가입 성공! 로그인해주세요~');"
						+ "location.href='login';</script>");			
			}else {
				out.print("<script>alert('중복된 아이디가 존재합니다.');"
						+ "location.href='registerForm';</script>");
			}
		}
	}
	
}
