package com.lucianaugusto.ladi.controllers;

import com.lucianaugusto.ladi.services.GreetingService;

public class SetterInjectionController {

	private GreetingService greetingService;
	
	public void setGreetingService(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	public String getGreeting() {
		return greetingService.sayGreeting();
	}
}
