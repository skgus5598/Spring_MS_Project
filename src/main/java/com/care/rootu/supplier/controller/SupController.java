package com.care.rootu.supplier.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.rootu.supplier.dto.SupDTO;
import com.care.rootu.supplier.service.ISupService;

@Controller
@RequestMapping("supply")
public class SupController {
	
	@Autowired ISupService ss;
	
	@GetMapping("supList")
	public String supplierListView(Model model) {
		ss.supList(model);
		return "/supplier/supList";
	}
	
	@GetMapping("supRegister")
	public String resgisterForm() {
	//	return "/supplier/supRegister";
		return "/supplier/supRegister";
	}
	
	@PostMapping("createSup")
	public void createSupplier(SupDTO dto, HttpServletResponse response) {		
			ss.createSupplier(dto, response);	
	}
	
}
