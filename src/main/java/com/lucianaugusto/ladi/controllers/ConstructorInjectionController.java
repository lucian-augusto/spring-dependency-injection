package com.lucianaugusto.ladi.controllers;

import com.lucianaugusto.ladi.services.GreetingService;

public class ConstructorInjectionController {
	
	private final GreetingService greetingService;

	public ConstructorInjectionController(GreetingService greetingService) {
		super();
		this.greetingService = greetingService;
	}

	public String getGreeting() {
		return greetingService.sayGreeting();
	}
}
