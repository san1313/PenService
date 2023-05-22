package com.pen.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class PenMesApplicationTests {
	
	
	@Test
	void contextLoads() {
		BCryptPasswordEncoder be = new BCryptPasswordEncoder();
		System.out.println(be.encode("jdbc:log4jdbc:oracle:thin:@3.34.113.10:1521/xe"));
	}

}
