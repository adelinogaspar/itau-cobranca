package com.gaspar.cobranca;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(
		properties={"spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration"})
@SpringBootTest
class CobrancaApplicationTests {

	//@Test
	void contextLoads() {
	}

}
