package com.softtek.java.advance.entities;

public class Pet {
	
	private int petId;
	private String name;
	private String breed;
	private AnimalType animalType;
	private Veterinary veterinary;
	
	
	
	public Pet() {
		
	}



	public int getPetId() {
		return petId;
	}



	public void setPetId(int petId) {
		this.petId = petId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getBreed() {
		return breed;
	}



	public void setBreed(String breed) {
		this.breed = breed;
	}



	public AnimalType getAnimalType() {
		return animalType;
	}



	public void setAnimalType(AnimalType animalType) {
		this.animalType = animalType;
	}



	public Veterinary getVeterinary() {
		return veterinary;
	}



	public void setVeterinary(Veterinary veterinary) {
		this.veterinary = veterinary;
	}

	

}
