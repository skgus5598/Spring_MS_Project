package com.care.rootu.mybatis.customer;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.care.rootu.customer.dto.CustomerDTO;

public interface CustomerMapper {
												//db로 두개 이상의 데이터를 보내줄 땐 꼭 구분자로 @ Param을 써야한다.
	public List<CustomerDTO> customerList(@Param("start")int start, @Param("end")int end);
	public int register(CustomerDTO dto);	
	public int getTotalPage();
}
