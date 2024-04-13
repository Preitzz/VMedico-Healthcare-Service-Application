package com.vmedico.medapp.service;

import org.springframework.stereotype.Service;

import com.vmedico.medapp.repository.ActionItemRepository;

@Service
public class ActionItemService {

    private final ActionItemRepository repository;

    // Constructor with dependency injection
    public ActionItemService(ActionItemRepository repository) {
        this.repository = repository;
    }

	public ActionItemRepository getRepository() {
		return repository;
	}

 
}

