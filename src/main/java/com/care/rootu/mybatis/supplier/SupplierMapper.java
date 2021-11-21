package com.care.rootu.mybatis.supplier;

import java.util.List;

import com.care.rootu.supplier.dto.SupDTO;

public interface SupplierMapper {
	
	public List<SupDTO> supList();
	public int insertSup(SupDTO dto); //성공 1, 실패 or 에러 = 0, -1 
}
