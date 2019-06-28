package br.com.runner.storecorner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.runner.storecorner.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
}
