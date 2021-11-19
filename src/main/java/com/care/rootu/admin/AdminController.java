package com.care.rootu.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.rootu.admin.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired AdminService as;
	
	@RequestMapping("home")
	public String home() {
		return "home";
	}
	@RequestMapping("login")
	public String loginPage() {
		return "/admin/login";
	}
	
	@PostMapping("loginChk")
//	public String login(@RequestParam(required = false) String id, @RequestParam(required = false) String password) {
		public void loginChk(HttpServletRequest req, HttpServletResponse response) {		
			as.loginChk(req.getParameter("id"), req.getParameter("password"), response);
	}

	
}
