package com.vmedico.medapp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.vmedico.medapp.service.ActionItemService;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/action-items")
public class ActionItemController {

    private final ActionItemService service;

    // Constructor with dependency injection
    public ActionItemController(ActionItemService service) {
        this.service = service;
    }

	public ActionItemService getService() {
		return service;
	}

}
