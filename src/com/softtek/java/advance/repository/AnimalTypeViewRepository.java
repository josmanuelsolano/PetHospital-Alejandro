package com.softtek.java.advance.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softtek.java.advance.connection.DriverManagerDatabase;
import com.softtek.java.advance.entities.AnimalType;

public class AnimalTypeViewRepository {
	
	public List<AnimalType> selectAllAnimalType(){
		
		List<AnimalType> types = new ArrayList<AnimalType>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM animal_type");
		Connection connection = DriverManagerDatabase.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
        	preparedStatement = connection.prepareStatement(sql.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	AnimalType animalType = new AnimalType();
				animalType.setAnimalTypeId(resultSet.getInt(1));
				animalType.setType(resultSet.getString(2));
				types.add(animalType);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.close(resultSet, preparedStatement, connection);
		}
		return types;
		
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
