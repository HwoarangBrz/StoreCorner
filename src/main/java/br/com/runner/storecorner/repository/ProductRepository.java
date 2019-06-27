package br.com.runner.storecorner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.runner.storecorner.domain.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer>  {
}
