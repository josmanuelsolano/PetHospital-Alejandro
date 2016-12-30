package com.softtek.java.advance.controller;

import com.softtek.java.advance.services.PetService;

import java.util.Scanner;

import com.softtek.java.advance.services.AnimalTypeService;
import com.softtek.java.advance.services.VeterinaryService;

public class Tests {

	public static void main(String[] args) {
		
		
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("****WELCOME TO PET HOSPITAL****\n");
		sb.append("MENU:\n");
		sb.append("\t Option 1 ->  Animal type\n");
		sb.append("\t Option 2 ->  Veterinary\n");
		sb.append("\t Option 3 ->  Pet\n");
		sb.append("\t Option 4 ->  Exit\n");
		System.out.println(sb.toString());
		Scanner sc = new Scanner(System.in);
		int option = 0;
		while(option != 4){
			System.out.println("Your Option: ");
			option = sc.nextInt();
			switch (option) {
			case 1:
				AnimalTypeService animalTypeServices = new AnimalTypeService();
				System.out.println("if you want create select 1");
				System.out.println("if you want update select 2");
				int subOptionType = sc.nextInt();
				if(subOptionType == 1){
					System.out.println(animalTypeServices.createAnimaltype());
				}else {
					System.out.println(animalTypeServices.updateAnimalType());
				}
				break;
			case 2:
				VeterinaryService veterinaryService = new VeterinaryService();
				System.out.println("if you want create select 1");
				System.out.println("if you want update select 2");
				int subOptionVeterinary = sc.nextInt();
				if(subOptionVeterinary == 1){
					System.out.println(veterinaryService.createVeterinary());
				}else {
					System.out.println(veterinaryService.updateVeterinary());
				}
				break;
			case 3:
				PetService petService = new PetService();
				System.out.println("Create a Pet");
				System.out.println(petService.createPet());
				break;
			default:
				System.out.println("Is not a valid option");
				break;
			}
		}
		
	}

}
