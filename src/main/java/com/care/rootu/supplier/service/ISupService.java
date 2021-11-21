package com.care.rootu.supplier.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.care.rootu.supplier.dto.SupDTO;

public interface ISupService {
	
	public void supList(Model model);
	public void createSupplier(SupDTO dto, HttpServletResponse response);
}
