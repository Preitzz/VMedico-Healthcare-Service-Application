package com.vmedico.medapp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.vmedico.medapp.service.HealthMonitorService;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/health-monitor")
public class HealthMonitorController {

    private final HealthMonitorService service;

    // Constructor with dependency injection
    public HealthMonitorController(HealthMonitorService service) {
        this.service = service;
    }

	public HealthMonitorService getService() {
		return service;
	}

    
}
