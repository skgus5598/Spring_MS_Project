package com.care.rootu.supplier.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.rootu.mybatis.supplier.SupplierMapper;
import com.care.rootu.supplier.dto.SupDTO;

@Service
public class SupSerivce implements ISupService {
	
	@Autowired SupplierMapper sm;
	
	@Override
	public void supList(Model model) {
		List<SupDTO> dto = sm.supList();
		model.addAttribute("dto", dto);
	}
	
	public void createSupplier(SupDTO dto, HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		int result = 0;
		try {
			 result = sm.insertSup(dto);
			 System.out.println("결과 : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}				
		if(result == 1) {
			out.print("<script>alert('거래처 추가 성공!');"
					+ "location.href='supList';</script>");
		}else {
			out.print("<script>alert('등록에 실패하였습니다.');"
					+ "location.href='supRegister';</script>");
		}
		
	}

}
