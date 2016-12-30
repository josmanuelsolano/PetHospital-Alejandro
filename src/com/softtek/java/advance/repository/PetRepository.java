package com.softtek.java.advance.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.softtek.java.advance.connection.DriverManagerDatabase;
import com.softtek.java.advance.entities.Pet;

public class PetRepository {
	
	public void createPet(Pet pet){
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO pet (name, breed, animal_type_id, veterinary_id)");
		sql.append("VALUES (?, ?, ?, ?)");

	        Connection connection = DriverManagerDatabase.getConnection();
	        PreparedStatement preparedStatement = null;
	        try {

	            preparedStatement = connection.prepareStatement(sql.toString());
	            preparedStatement.setString(1, pet.getName());
	            preparedStatement.setString(2, pet.getBreed());
	            preparedStatement.setInt(3, pet.getAnimalType().getAnimalTypeId());
	            preparedStatement.setInt(4, pet.getVeterinary().getVeterinaryId());
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            this.close(preparedStatement, connection);
	        }
		
	}
	
	public int updatePet(Pet pet) {

        int result = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE pet SET name = ?, breed = ?, veterinary_id = ? ");
        sql.append("WHERE pet_id = ?");

        Connection connection = DriverManagerDatabase.getConnection();
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1, pet.getName());
            preparedStatement.setString(2, pet.getBreed());
            preparedStatement.setInt(3, pet.getVeterinary().getVeterinaryId());
            preparedStatement.setInt(4, pet.getPetId());
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close(preparedStatement, connection);
        }
        return result;
    }
	
	private void close(PreparedStatement preparedStatement,
	        Connection connection) {

	        if (preparedStatement != null && connection != null) {

	            try {
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
