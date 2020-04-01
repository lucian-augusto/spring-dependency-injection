package com.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"dog", "default"})
@Service("petService")
public class DogPetService implements PetService{
	@Override
	public String getPetType() {
		// TODO Auto-generated method stub
		return "Dogs are the best!";
	}
}
