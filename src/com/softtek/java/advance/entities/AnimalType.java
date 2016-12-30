package com.softtek.java.advance.entities;

public class AnimalType {
	
	private int animalTypeId;
	private String type;
	
	
	
	public AnimalType() {
		
	}
	
	public int getAnimalTypeId() {
		return animalTypeId;
	}
	public void setAnimalTypeId(int animalTypeId) {
		this.animalTypeId = animalTypeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return animalTypeId + " [Id=" + animalTypeId + ", Animal=" + type + "]";
	}
	
	

}
