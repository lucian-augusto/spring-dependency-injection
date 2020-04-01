package com.lucianaugusto.ladi.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.services.PetService;

@Controller
public class PetController {

    private final PetService petService;
    
    

    public PetController(@Qualifier("petService") PetService petService) {
		super();
		this.petService = petService;
	}



	public String whichPetIsTheBest(){
        return petService.getPetType();
    }
}
