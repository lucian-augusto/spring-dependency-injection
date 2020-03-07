package com.lucianaugusto.ladi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.lucianaugusto.ladi.controllers.ConstructorInjectionController;
import com.lucianaugusto.ladi.controllers.MyController;
import com.lucianaugusto.ladi.controllers.PropertyInjectionController;
import com.lucianaugusto.ladi.controllers.SetterInjectionController;

@SpringBootApplication
public class LaDiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LaDiApplication.class, args);
		
		MyController myController = (MyController) context.getBean("myController");
		
		String greeting = myController.sayHello();
		
		System.out.println(greeting);
		
		System.out.println("------ Property");
		PropertyInjectionController propertyInjectionController = (PropertyInjectionController) context.getBean("propertyInjectionController");
		System.out.println(propertyInjectionController.getGreeting());
		
		System.out.println("------ Property");
		SetterInjectionController setterInjectionController = (SetterInjectionController) context.getBean("setterInjectionController"); 
		System.out.println(setterInjectionController.getGreeting());
		
		System.out.println("------ Constructor");
		ConstructorInjectionController constructorInjectionController = (ConstructorInjectionController) context.getBean("constructorInjectionController");
		System.out.println(constructorInjectionController.getGreeting());
	}

}
