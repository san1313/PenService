package com.pen.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.Setter;

@SpringBootTest
class PenMesApplicationTests {
	
	
	@Test
	void contextLoads() {
		BCryptPasswordEncoder be = new BCryptPasswordEncoder();
		System.out.println(be.encode("test"));
	}

}
