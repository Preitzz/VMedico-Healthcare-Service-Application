package com.vmedico.medapp.service;

import org.springframework.stereotype.Service;

import com.vmedico.medapp.repository.HealthMonitorRepository;

@Service
public class HealthMonitorService {

    private final HealthMonitorRepository repository;

    // Constructor with dependency injection
    public HealthMonitorService(HealthMonitorRepository repository) {
        this.repository = repository;
    }

	public HealthMonitorRepository getRepository() {
		return repository;
	}


}
