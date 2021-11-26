package com.care.rootu.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.rootu.customer.dto.CustomerDTO;
import com.care.rootu.customer.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired CustomerService cs;
	
	@GetMapping("customerList")
	public String customerView(@RequestParam( required = false, defaultValue = "1") int num ,Model model) {
		System.out.println("스타트페이지 스타트 : " + num);
		cs.customerList(num,model);
		return "/customer/customerList";
	}
	@GetMapping("registerView")
	public String registerView() {
		return "/customer/customerRegi";
	}
	
	@PostMapping("register")
	public String register(CustomerDTO dto) {
		cs.register(dto);
		return "redirect:/customer/customerList";
	}
	
}
