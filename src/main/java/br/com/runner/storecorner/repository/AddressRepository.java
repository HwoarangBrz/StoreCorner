package br.com.runner.storecorner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.runner.storecorner.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
