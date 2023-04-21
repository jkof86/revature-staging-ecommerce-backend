package com.revature.ecommerce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.ecommerce.model.EcommerceUser;
import com.revature.ecommerce.service.EcommerceService;


@SpringBootTest
class EcommerceApplicationTests {

	// first we create a service bean
	@Autowired
	EcommerceService testServ;

	// this test checks the login functionality
	@Test
	void loginTest() {
		// arrange
		boolean result;

		// act
		result = testServ.loginUser("lkelberman0@mtv.com", "vHYjwET");

		// assert
		assertEquals(true,result);
	}

	@Test
	@Transactional //allows the test to be rolled back after completion
	//this test checks the registration functionality
	void registerTest() {
		// arrange
		EcommerceUser result;

		// act
		result = testServ.addUser(new EcommerceUser());

		// assert
		assertNotNull(result);;
	}

	

}
