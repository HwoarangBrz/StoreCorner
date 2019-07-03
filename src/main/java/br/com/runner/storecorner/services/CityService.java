package br.com.runner.storecorner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.runner.storecorner.domain.City;
import br.com.runner.storecorner.repository.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository repo;

	public List<City> findByState(Integer stateId) {
		return repo.findCities(stateId);
	}
}
