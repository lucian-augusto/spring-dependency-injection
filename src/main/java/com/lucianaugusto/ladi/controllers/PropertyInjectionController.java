package com.lucianaugusto.ladi.controllers;

import com.lucianaugusto.ladi.services.GreetingService;

public class PropertyInjectionController {

	public GreetingService greetingService;
	
	public String getGreeting() {
		return greetingService.sayGreeting();
	}
}
