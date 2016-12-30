package com.softtek.java.advance.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.softtek.java.advance.connection.DriverManagerDatabase;
import com.softtek.java.advance.entities.Veterinary;

public class VeterinaryRepository {
	
	public void createVeterinary(Veterinary veterinary){
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO veterinary (name, lastname, school_card)");
		sql.append("VALUES (?, ?, ?)");

	        Connection connection = DriverManagerDatabase.getConnection();
	        PreparedStatement preparedStatement = null;
	        try {

	            preparedStatement = connection.prepareStatement(sql.toString());
	            preparedStatement.setString(1, veterinary.getName());
	            preparedStatement.setString(2, veterinary.getLastname());
	            preparedStatement.setString(3, veterinary.getSchoolCard());
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            this.close(preparedStatement, connection);
	        }
		
	}
	
	public int updateVeterinary(Veterinary veterinary) {

        int result = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE veterinary SET name = ?, lastname = ?");
        sql.append("WHERE veterinary_id = ?");

        Connection connection = DriverManagerDatabase.getConnection();
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1, veterinary.getName());
            preparedStatement.setString(2, veterinary.getLastname());
            preparedStatement.setInt(3, veterinary.getVeterinaryId());
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
