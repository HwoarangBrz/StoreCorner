package br.com.runner.storecorner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.runner.storecorner.domain.State;
import br.com.runner.storecorner.repository.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository repo;
	
	public List<State> findAll() {
		return repo.findAllByOrderByName();
	}
}
