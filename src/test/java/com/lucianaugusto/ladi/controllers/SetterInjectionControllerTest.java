package com.lucianaugusto.ladi.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lucianaugusto.ladi.services.GreetingServiceImpl;

class SetterInjectionControllerTest {

	SetterInjectionController controller;
	
	@BeforeEach
	void setUp() {
		controller = new SetterInjectionController();
		controller.setGreetingService(new GreetingServiceImpl());
	}

	@Test
	void testGetGreetingt() {
		System.out.println(controller.getGreeting());
	}

}
