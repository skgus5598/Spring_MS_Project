package com.care.rootu.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.care.rootu.admin.dto.AdminDTO;
import com.care.rootu.admin.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired AdminService as;
	
	@RequestMapping("home")
	public String home() {
		return "/default/home";
	}
	@RequestMapping("login")
	public String loginPage() {
		return "/admin/login";
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	
	@PostMapping("loginChk")
//	public String login(@RequestParam(required = false) String id, @RequestParam(required = false) String password) {
		public void loginChk(HttpSession session, HttpServletRequest req, HttpServletResponse response) {		
			as.loginChk(req.getParameter("id"), req.getParameter("password"), response, session);
	}
	
	@GetMapping("registerForm")
	public String registerForm() {
		return "/admin/register";
	}
	@RequestMapping("createAcc")
	public void createAcc(AdminDTO dto, HttpServletRequest req, HttpServletResponse response) {		
		as.createAcc(dto, req.getParameter("passwordChk") , response);
	}

	
}
