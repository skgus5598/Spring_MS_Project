package com.care.rootu.mybatis.admin;

import com.care.rootu.admin.dto.AdminDTO;

public interface AdminMapper {
	
	public AdminDTO loginChk(String id);
	public int createAcc(AdminDTO dto);
}
