package com.lucianaugusto.ladi.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lucianaugusto.ladi.services.GreetingServiceImpl;

class ConstructorInjectionControllerTest {

	ConstructorInjectionController controller;
	
	@BeforeEach
	void setUp() {
		controller = new ConstructorInjectionController(new GreetingServiceImpl());
	}

	@Test
	void testGetGreeting() {
		System.out.println(controller.getGreeting());
	}

}
