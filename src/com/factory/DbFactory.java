package com.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbFactory {
   Connection con;
	public Connection getMySqlConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","anim");
			   con.setAutoCommit(false);
            
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 return con;			
			
		
		
	}
	
	
	public void closeMySqlConnection(){
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}
}
