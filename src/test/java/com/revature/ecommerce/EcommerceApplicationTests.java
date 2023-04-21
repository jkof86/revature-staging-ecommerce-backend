package com.revature.ecommerce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.revature.ecommerce.service.EcommerceService;


@SpringBootTest
class EcommerceApplicationTests {

	// first we create a service bean
	@Autowired
	EcommerceService testServ;

	// this test checks the login functionality
	@Test
	void contextLoads() {
		// arrange
		boolean result;

		// act
		result = testServ.loginUser("lkelberman0@mtv.com", "vHYjwET");

		// assert
		assertEquals(true,result);
	}

}
