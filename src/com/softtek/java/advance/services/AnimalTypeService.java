package com.softtek.java.advance.services;

import java.util.List;
import java.util.Scanner;

import com.softtek.java.advance.entities.AnimalType;
import com.softtek.java.advance.repository.AnimalTypeRepository;
import com.softtek.java.advance.repository.AnimalTypeViewRepository;

public class AnimalTypeService {
	
	Scanner sc = new Scanner(System.in);
	AnimalTypeRepository animalTypeRepository = new AnimalTypeRepository();
	AnimalType animalType = new AnimalType();
	
	public String createAnimaltype(){
		System.out.println("Give me a type");
		String type = sc.nextLine();
		if(!ValidationHelpers.isString(type)){
			animalType.setType(type);
			animalTypeRepository.createAnimalType(animalType);
			return "Animal type created";
		}else{
			return "the animal cant be an empty type";
		}
	}
	
	public String updateAnimalType(){
		
		AnimalTypeViewRepository animalTypeViewRepository = new AnimalTypeViewRepository();
		List<AnimalType> animalTypes = animalTypeViewRepository.selectAllAnimalType();
		CommonService.printList(animalTypes);
		System.out.println("Select the number of animal to be updated");
		int id = sc.nextInt();
		if(ValidationHelpers.existById(animalTypes, id)){
			Scanner sc = new Scanner(System.in);
			System.out.println("Give me a new type of animal");
			String type = sc.nextLine();
			sc.close();
			if (!ValidationHelpers.isString(type)) {
				animalType = animalTypes.get(id-1);
				animalType.setType(type); 
				if(animalTypeRepository.updateAnimalType(animalType) == 1){
					return "Type of animal updated";
				}else{
					return "Something happened and the type of animal could not be updated";
				}
			}else{
				return "The animal cant be empty or null";
			}	
		}else{
			return "The selected number of animal type dont exist in the list";
		}
		
	}

}
