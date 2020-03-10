package com.lucianaugusto.ladi.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lucianaugusto.ladi.services.ConstructorGreetingService;

class SetterInjectionControllerTest {

	SetterInjectionController controller;
	
	@BeforeEach
	void setUp() {
		controller = new SetterInjectionController();
		controller.setGreetingService(new ConstructorGreetingService());
	}

	@Test
	void testGetGreetingt() {
		System.out.println(controller.getGreeting());
	}

}
