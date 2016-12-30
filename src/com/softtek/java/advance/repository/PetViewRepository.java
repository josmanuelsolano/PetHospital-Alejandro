package com.softtek.java.advance.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.softtek.java.advance.connection.DriverManagerDatabase;
import com.softtek.java.advance.entities.AnimalType;
import com.softtek.java.advance.entities.Pet;
import com.softtek.java.advance.entities.Veterinary;

public class PetViewRepository {
	
	public Pet getPetById(int id){
		
		Pet pet = new Pet();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.pet_id, p.name, p.breed, at.animal_type_id, at.type,"
				+ "v.veterinary_id, v.name, v.lastname, v.shool_card ");
		sql.append("FROM pet p");
		sql.append("INNER JOIN animal_type at ON p.animal_type_id = at.animal_type_id ");
		sql.append("INNER JOIN veterinary v ON p.veterinary_id = v.veterinary_id");
		sql.append("WHERE p.pet_id = ?");
		
		Connection connection = DriverManagerDatabase.getConnection();
		PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
        	preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
 
            if(resultSet.next()){
            	pet.setPetId(resultSet.getInt(1));
            	pet.setName(resultSet.getString(2));
            	pet.setBreed(resultSet.getString(3));
                AnimalType animalType = new AnimalType();
                animalType.setAnimalTypeId(resultSet.getInt(4));
                animalType.setType(resultSet.getString(5));
                pet.setAnimalType(animalType);
                Veterinary veterinary = new Veterinary();
                veterinary.setVeterinaryId(resultSet.getInt(6));
                veterinary.setName(resultSet.getString(7));
                veterinary.setLastname(resultSet.getString(8));
                veterinary.setSchoolCard(resultSet.getString(9));
                pet.setVeterinary(veterinary);
            }
		} catch (SQLException e) {
            e.printStackTrace();
        } finally {

            this.close(resultSet, preparedStatement, connection);
        }
		return pet;
		
	}
	
	private void close(ResultSet resultSet,
	        PreparedStatement preparedStatement,
	        Connection connection) {

	        if (resultSet != null && preparedStatement != null
	            && connection != null) {

	            try {
	                if (!resultSet.isClosed()) {
	                    resultSet.close();
	                }

	                if (!preparedStatement.isClosed()) {
	                    preparedStatement.close();
	                }

	                if (!connection.isClosed()) {
	                    connection.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

}
