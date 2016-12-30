package com.softtek.java.advance.services;

import java.util.List;

import com.softtek.java.advance.entities.AnimalType;

public final class ValidationHelpers {
	
	static boolean isString(String string){	
		
		return (string.isEmpty() || string == null);
	}

	static boolean isNumber(String string){
			try {
				long entero = Long.parseLong(string);
			} catch (Exception e) {
				return false;
			}
		return true;
	}
	
	static boolean existById(List<?> list, int id){
		try {
			list.contains(list.get(id-1));
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
	
	static boolean existTypeByString(List<AnimalType> list, String string){
		for (AnimalType animalType : list) {
			if(animalType.getType() == string){
				return true;
			}
		}
		return false;
	}
}
