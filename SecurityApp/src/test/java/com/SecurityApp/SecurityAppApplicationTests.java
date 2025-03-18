package com.SecurityApp;

import com.SecurityApp.entities.User;
import com.SecurityApp.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityAppApplicationTests {

	@Autowired
	private JwtService jwtService;



	@Test
	void contextLoads() {

		User user=new User(4L,"ajeet@gmail.com","1234");

		String token=jwtService.generateAccessToken(user);

		System.out.println(token);

		Long id=jwtService.getUserIdFromToken(token);

		System.out.println(id);
	}

}
