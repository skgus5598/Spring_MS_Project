package com.care.rootu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import com.care.rootu.customer.dto.CustomerDTO;
import com.care.rootu.customer.service.CustomerService;
import com.care.rootu.mybatis.customer.CustomerMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:testCrud.xml",
			"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestCustomer {

		@Autowired CustomerService cs;
		@Autowired CustomerMapper cm;
		
		@Test
		public void testInsert() {
			CustomerDTO dto = new CustomerDTO();
			dto.setCustomerId(0);
			dto.setCustomerName("");
			dto.setContactNum("011-2345-6789");
			dto.setAddress("");
			dto.setEtc("nothing special");
			
			cs.register(dto);			
		}
}
