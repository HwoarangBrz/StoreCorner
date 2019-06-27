package br.com.runner.storecorner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.runner.storecorner.domain.Category;
import br.com.runner.storecorner.domain.Product;
import br.com.runner.storecorner.repository.CategoryRepository;
import br.com.runner.storecorner.repository.ProductRepository;

@SpringBootApplication
public class StorecornerApplication implements CommandLineRunner {

	@Autowired
	CategoryRepository repoCategory;
	@Autowired
	ProductRepository repoProduct;
	
	public static void main(String[] args) {
		SpringApplication.run(StorecornerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Hardware");
		Category cat2 = new Category(null, "Software");
		Category cat3 = new Category(null, "Computadores");
		
		
		Product p1 = new Product(null, "SSD 120", 115.0);		
		Product p2 = new Product(null, "SSD 240", 210.5);
		Product p3 = new Product(null, "SSD 480", 315.1);
		Product p4 = new Product(null, "Notebook Dell i7", 2535.0);
		Product p5 = new Product(null, "MS Windows 10 Home", 400.0);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3, p4));
		cat2.getProducts().addAll(Arrays.asList(p5));
		cat3.getProducts().addAll(Arrays.asList(p4, p5));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1));
		p3.getCategories().addAll(Arrays.asList(cat1));
		p4.getCategories().addAll(Arrays.asList(cat1, cat3));
		p5.getCategories().addAll(Arrays.asList(cat2, cat3));
		
		repoCategory.saveAll(Arrays.asList(cat1, cat2, cat3));
		repoProduct.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
	}

}
