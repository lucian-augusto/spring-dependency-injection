package com.lucianaugusto.ladi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.lucianaugusto.ladi.controllers.ConstructorInjectionController;
import com.lucianaugusto.ladi.controllers.I18nController;
import com.lucianaugusto.ladi.controllers.MyController;
import com.lucianaugusto.ladi.controllers.PetController;
import com.lucianaugusto.ladi.controllers.PropertyInjectionController;
import com.lucianaugusto.ladi.controllers.SetterInjectionController;

@SpringBootApplication // By default this annotations does a component scan of all the packages below itself 
// (@SpringBootApplication). To add packages from outside this range, it's necessary to specify them using the 
// @ComponentScan annotation.
// To test the use of the @ComponentScan Annotation, the project was refactored, the services package was moved from the
// com.lucianaugusto.ladi package to the com package, so it was outside the range of the @SpringBootApplication annotation 
// on purpose. So, to be able to run the application once again, it's necessary to use to add the service package using the 
// @ComponentScan
@ComponentScan(basePackages = {"com.services", "com.lucianaugusto.ladi"}) // Note that the @ComponentScan Annotation overwrites
// the default scan performed by the @SpringBootApplication, so we have to add all the packages manually (that's why we're adding
// the com.lucianaugusto.ladi package again, where it goes down the whole package tree)
public class LaDiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LaDiApplication.class, args);
		
		I18nController i18nController = (I18nController) context.getBean("i18nController");
		System.out.println(i18nController.sayHello());
		
		MyController myController = (MyController) context.getBean("myController");
		System.out.println("------ Primary Bean");
		System.out.println(myController.sayHello());
		
		System.out.println("------ Property");
		PropertyInjectionController propertyInjectionController = (PropertyInjectionController) context.getBean("propertyInjectionController");
		System.out.println(propertyInjectionController.getGreeting());
		
		System.out.println("------ Property");
		SetterInjectionController setterInjectionController = (SetterInjectionController) context.getBean("setterInjectionController"); 
		System.out.println(setterInjectionController.getGreeting());
		
		System.out.println("------ Constructor");
		ConstructorInjectionController constructorInjectionController = (ConstructorInjectionController) context.getBean("constructorInjectionController");
		System.out.println(constructorInjectionController.getGreeting());
		
		System.out.println("------ Pet Assignment");
		PetController petController = context.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());


	}

}
