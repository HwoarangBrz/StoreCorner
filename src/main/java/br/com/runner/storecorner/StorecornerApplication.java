package br.com.runner.storecorner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.runner.storecorner.domain.Category;
import br.com.runner.storecorner.repository.CategoryRepository;

@SpringBootApplication
public class StorecornerApplication implements CommandLineRunner {

	@Autowired
	CategoryRepository repoCategory;
	
	public static void main(String[] args) {
		SpringApplication.run(StorecornerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Hardware");
		Category cat2 = new Category(null, "Software");
		
		repoCategory.saveAll(Arrays.asList(cat1, cat2));
	}

}
