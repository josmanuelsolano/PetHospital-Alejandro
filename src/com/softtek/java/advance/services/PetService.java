package com.softtek.java.advance.services;

import java.util.List;
import java.util.Scanner;

import com.softtek.java.advance.entities.AnimalType;
import com.softtek.java.advance.entities.Pet;
import com.softtek.java.advance.entities.Veterinary;
import com.softtek.java.advance.repository.AnimalTypeViewRepository;
import com.softtek.java.advance.repository.PetRepository;
import com.softtek.java.advance.repository.VeterinaryViewRepository;

public class PetService {
	
	Pet pet = new Pet();
	PetRepository petRepository = new PetRepository();
	Scanner sc = new Scanner(System.in);
	
	public String createPet(){
		System.out.println("name");
		pet.setName(sc.nextLine());
		System.out.println("breed");
		pet.setBreed(sc.nextLine());
		AnimalType animalType = new AnimalType();
		AnimalTypeViewRepository animalTypeViewRepository = new AnimalTypeViewRepository();
		List<AnimalType> animalTypes = animalTypeViewRepository.selectAllAnimalType();
		CommonService.printList(animalTypes);
		System.out.println("Select the number of animal type");
		int animalId = sc.nextInt();
		if(ValidationHelpers.existById(animalTypes, animalId)){
			pet.setAnimalType(animalTypes.get(animalId-1));
			Scanner sc = new Scanner(System.in);
			VeterinaryViewRepository veterinaryViewRepository = new VeterinaryViewRepository();
			List<Veterinary> veterinaries = veterinaryViewRepository.selectAllVeterynary();
			CommonService.printList(veterinaries);
			System.out.println("Select the number of veterinary");
			int veterinaryId = sc.nextInt();
			if (ValidationHelpers.existById(veterinaries, veterinaryId)) {
				pet.setVeterinary(veterinaries.get(veterinaryId-1));
				petRepository.createPet(pet);
				return "Pet created";			
			} else {
				return "The selected number of veterinary dont exist in the list";
			}
		}else{
			return "The selected number of animal type dont exist in the list";
		}
		
	}
}
