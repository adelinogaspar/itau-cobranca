package com.gaspar.cobrancanotificaemail;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@OpenAPIDefinition(
		info = @Info(
				title = "itau-cobranca-email",
				version = "0.0"
		)
)
@SpringBootApplication(exclude={MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class CobrancaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CobrancaApplication.class, args);
	}

}
