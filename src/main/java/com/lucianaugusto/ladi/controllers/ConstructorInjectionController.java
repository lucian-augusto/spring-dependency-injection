package com.lucianaugusto.ladi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lucianaugusto.ladi.services.GreetingService;

@Controller
public class ConstructorInjectionController {
	
	private final GreetingService greetingService;

	@Autowired
	public ConstructorInjectionController(GreetingService greetingService) {
		super();
		this.greetingService = greetingService;
	}

	public String getGreeting() {
		return greetingService.sayGreeting();
	}
}
