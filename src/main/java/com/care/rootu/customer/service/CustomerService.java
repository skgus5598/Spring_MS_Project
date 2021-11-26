package com.care.rootu.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.rootu.customer.dto.CustomerDTO;
import com.care.rootu.mybatis.customer.CustomerMapper;

@Service
public class CustomerService {
	
	@Autowired CustomerMapper cm;
	
	public void customerList(int startPage, Model model) {
		
		int pageNum = 4; //페이지당 보여질 글 개수 
		int allCount = cm.getTotalPage();  //게시글 총 개수 
		System.out.println("all count : " + allCount);
		int totalEndPage = allCount / pageNum;
		if(allCount % pageNum != 0) {
			totalEndPage ++;
		}
		int end = startPage * pageNum;
		int start = end + 1 - pageNum;			

		model.addAttribute("totalEndPage", totalEndPage);
		model.addAttribute("boardList",  cm.customerList(start, end));
	}
	
	public void register(CustomerDTO dto) {
		if(dto.getCustomerName().isEmpty() ||
			dto.getContactNum().isEmpty() ||dto.getAddress().isEmpty()) {
			System.out.println("등록 실패.빈칸을 채워줘야함 .나중에 ajax로 처리 ");
		} else {
			int result = cm.register(dto);
		}		
	}
}










