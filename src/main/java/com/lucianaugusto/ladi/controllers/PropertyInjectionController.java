package com.lucianaugusto.ladi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lucianaugusto.ladi.services.GreetingService;

@Controller
public class PropertyInjectionController {

	@Autowired
	public GreetingService greetingService;
	
	public String getGreeting() {
		return greetingService.sayGreeting();
	}
}
