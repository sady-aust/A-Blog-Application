package com.toufiq.DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.toufiq.Model.Admin;

public class AdminGetway {
	
	public AdminGetway() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch (ClassNotFoundException  e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public Admin getAdmin(Admin admin) {
		Connection connection = DatabaseManager.GetConnection();
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM admins WHERE email = '"+admin.getEmail()+"'AND password='"+admin.getPassword()+"'";
			ResultSet res = statement.executeQuery(query);
			
			if(res.next()) {
				
				Admin myAdmin = new Admin(res.getString("email"), res.getString("password"));
				return myAdmin;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(connection!=null) {
					connection.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return null;
		
	}

}
