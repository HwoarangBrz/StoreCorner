package br.com.runner.storecorner.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
}
