package com.lucianaugusto.ladi.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.services.ConstructorGreetingService;

class PropertyInjectionControllerTest {

	PropertyInjectionController controller;
	
	@BeforeEach
	void setUp() {
		controller = new PropertyInjectionController();
		
		controller.greetingService = new ConstructorGreetingService();
	}
	
	@Test
	void getGreeting() {
		System.out.println(controller.getGreeting());
	}

}
