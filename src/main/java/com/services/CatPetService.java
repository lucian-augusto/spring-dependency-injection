package com.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("cat")
@Service("petService")
public class CatPetService implements PetService {
	@Override
	public String getPetType() {
		// TODO Auto-generated method stub
		return "Cats are the best!";
	}
}
