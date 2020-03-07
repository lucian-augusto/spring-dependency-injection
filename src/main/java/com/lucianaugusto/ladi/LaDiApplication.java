package com.lucianaugusto.ladi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.lucianaugusto.ladi.controllers.MyController;

@SpringBootApplication
public class LaDiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LaDiApplication.class, args);
		
		MyController myController = (MyController) context.getBean("myController");
		
		String greeting = myController.sayHello();
		
		System.out.println(greeting);
	}

}
