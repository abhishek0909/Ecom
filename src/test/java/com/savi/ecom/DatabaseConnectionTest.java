package com.savi.ecom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class DatabaseConnectionTest {

@Test
public void databaseConnectionTest(){
	
	   Connection connect = null;
	   Statement statement = null;
	   ResultSet resultSet = null;
	  
	   
	   try {
	   Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = DriverManager
	          .getConnection("jdbc:mysql://localhost/ecom?"
	              + "user=root&password=admin");

	      // Statements allow to issue SQL queries to the database
	      statement = connect.createStatement();
	      // Result set get the result of the SQL query
	      resultSet = statement
	          .executeQuery("select * from ecom.user");
	        
	     
			while (resultSet.next()) {
			      
			      String user = resultSet.getString("userid");
			      String email = resultSet.getString("email");
			      
			      System.out.println("User: " + user);
			      System.out.println("email: " + email);
			     
			    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
}
	
}
