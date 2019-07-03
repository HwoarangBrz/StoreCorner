package br.com.runner.storecorner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StorecornerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StorecornerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	
	}	
}
