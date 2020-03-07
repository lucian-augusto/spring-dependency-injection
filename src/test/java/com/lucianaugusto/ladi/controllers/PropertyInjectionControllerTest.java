package com.lucianaugusto.ladi.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lucianaugusto.ladi.services.GreetingServiceImpl;

class PropertyInjectionControllerTest {

	PropertyInjectionController controller;
	
	@BeforeEach
	void setUp() {
		controller = new PropertyInjectionController();
		
		controller.greetingService = new GreetingServiceImpl();
	}
	
	@Test
	void getGreeting() {
		System.out.println(controller.getGreeting());
	}

}
