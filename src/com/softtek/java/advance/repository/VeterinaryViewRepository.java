package com.softtek.java.advance.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softtek.java.advance.connection.DriverManagerDatabase;
import com.softtek.java.advance.entities.Veterinary;

public class VeterinaryViewRepository {
	
	
	public List<Veterinary> selectAllVeterynary(){
		List<Veterinary> veterinaries = new ArrayList<Veterinary>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM veterinary");
		Connection connection = DriverManagerDatabase.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql.toString());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Veterinary veterinary = new Veterinary();
				veterinary.setVeterinaryId(resultSet.getInt(1));
				veterinary.setName(resultSet.getString(2));
				veterinary.setLastname(resultSet.getString(3));
				veterinary.setSchoolCard(resultSet.getString(4));
				veterinaries.add(veterinary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.close(resultSet, preparedStatement, connection);
		}	
		
		return veterinaries;
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
