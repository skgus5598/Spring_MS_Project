package com.care.rootu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.care.rootu.mybatis.supplier.SupplierMapper;
import com.care.rootu.supplier.dto.SupDTO;
import com.care.rootu.supplier.service.ISupService;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:testCrud.xml",
			"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestSupplier {
	@Autowired SupplierMapper sm;
	@Autowired ISupService ss;
	
	@Test
	public void testInsert() {
		SupDTO dto = new SupDTO();
		dto.setSupplierId(1);
		dto.setSupplierCode("abc");
		dto.setManager("rachel");
		dto.setAddress("seoul");
		dto.setCompanyName("samsung");
		dto.setContactNum(12341234);
		int result = sm.insertSup(dto);		
	}
}
