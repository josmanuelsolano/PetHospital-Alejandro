package com.softtek.java.advance.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.softtek.java.advance.connection.DriverManagerDatabase;
import com.softtek.java.advance.entities.AnimalType;

public class AnimalTypeRepository {
	
	public void createAnimalType(AnimalType animalType){
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO animal_type (animal)");
		sql.append("VALUES (?)");

	        Connection connection = DriverManagerDatabase.getConnection();
	        PreparedStatement preparedStatement = null;
	        try {

	            preparedStatement = connection.prepareStatement(sql.toString());
	            preparedStatement.setString(1, animalType.getType());
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            this.close(preparedStatement, connection);
	        }
		
	}
	
	public int updateAnimalType(AnimalType animalType) {

        int result = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE animal_type SET animal = ?");
        sql.append("WHERE animal_type_id = ?");

        Connection connection = DriverManagerDatabase.getConnection();
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1, animalType.getType());
            preparedStatement.setInt(2, animalType.getAnimalTypeId());
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
