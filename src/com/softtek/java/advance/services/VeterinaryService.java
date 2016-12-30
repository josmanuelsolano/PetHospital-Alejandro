
package com.softtek.java.advance.services;

import java.util.List;
import java.util.Scanner;

import com.softtek.java.advance.entities.Veterinary;
import com.softtek.java.advance.repository.VeterinaryRepository;
import com.softtek.java.advance.repository.VeterinaryViewRepository;

public class VeterinaryService {
	
	Veterinary veterinary =  new Veterinary();
	VeterinaryRepository veterinaryRepository = new VeterinaryRepository();
	Scanner sc = new Scanner(System.in);
	
	public String createVeterinary(){
		
		System.out.println("Name: ");
		veterinary.setName(sc.nextLine());
		System.out.println("Last name: ");
		veterinary.setLastname(sc.nextLine());
		System.out.println("School card: ");
		veterinary.setSchoolCard(sc.nextLine());
		
		veterinaryRepository.createVeterinary(veterinary);
		return "Veterinary created";
		
	}
	
	public String updateVeterinary(){
		
		VeterinaryViewRepository veterinaryViewRepository = new VeterinaryViewRepository();
		List<Veterinary> veterinaries = veterinaryViewRepository.selectAllVeterynary();
		CommonService.printList(veterinaries);
		System.out.println("Select the number of veterinary to be updated");
		int id = sc.nextInt();
		if(ValidationHelpers.existById(veterinaries, id)){
			Scanner sc = new Scanner(System.in);
			System.out.println("Name: ");
			String name = sc.nextLine();
			System.out.println("Last name: ");
			String lastname = sc.nextLine();
			sc.close();
			if(!ValidationHelpers.isString(name) && !ValidationHelpers.isString(lastname)){
				veterinary = veterinaries.get(id-1);
				veterinary.setName(name);
				veterinary.setLastname(lastname);
				if (veterinaryRepository.updateVeterinary(veterinary) == 1) {
					String algo = "Veterinary updated";
					return algo;
				} else {
					return "Something happend and the veterinary could not be updated";
				}
			}else{
				return "The name or last name cant be empty or null";
			}
		}else{
			return "The selected number of veterinary dont exist in the list";
		}
		
	}

}
