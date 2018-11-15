package com.toufiq.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.toufiq.Model.Admin;
import com.toufiq.Model.Category;

public class CategoryGetway {
	
	public CategoryGetway() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch (ClassNotFoundException  e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public int insertCategoey(Category aCategory) {
		Connection connection = DatabaseManager.GetConnection();
		int res = 0;
		try {
			Statement statement = connection.createStatement();
			String query = "INSERT INTO categories (categoryname,categorydescription,status) VALUES(?,?,?)";
			
			PreparedStatement myPreparedStatement = connection.prepareStatement(query);
			myPreparedStatement.setString(1, aCategory.getCategoryName());
			myPreparedStatement.setString(2, aCategory.getShortDescription());
			myPreparedStatement.setInt(3, aCategory.getPublicationStatus());
			res = myPreparedStatement.executeUpdate();
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
		
		return res;
		
	}
	
	public List<Category> getAllCategories(){
		List<Category> publishedCategories = new ArrayList<Category>();
		Connection connection = DatabaseManager.GetConnection();
		
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM categories";
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				Category category = new Category();
				category.setCategoryId(resultSet.getInt("id"));
				category.setCategoryName(resultSet.getString("categoryname"));
				category.setShortDescription(resultSet.getString("categorydescription"));
				category.setPublicationStatus(resultSet.getInt("status"));
				
				publishedCategories.add(category);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return publishedCategories;
	}
	
	public Category getCategoryByCategoryId(int id) {
		List<Category> publishedCategories = new ArrayList<Category>();
		Connection connection = DatabaseManager.GetConnection();
		
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM categories WHERE id ="+id;
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				Category category = new Category();
				category.setCategoryId(resultSet.getInt("id"));
				category.setCategoryName(resultSet.getString("categoryname"));
				category.setShortDescription(resultSet.getString("categorydescription"));
				category.setPublicationStatus(resultSet.getInt("status"));
				
				publishedCategories.add(category);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		if(publishedCategories.size()>0) {
			return publishedCategories.get(0);
		}
		return null;
	}

	public int updateCategory(Category aCategory) {
		Connection connection = DatabaseManager.GetConnection();
		int res = 0;
		try {
			Statement statement = connection.createStatement();
			String query = "UPDATE categories SET categoryname ='"+aCategory.getCategoryName()+"',categorydescription='"+aCategory.getShortDescription()+"',status="+aCategory.getPublicationStatus()+" WHERE id ="+aCategory.getCategoryId();
			
			res = statement.executeUpdate(query);
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
		
		return res;
		
	}

	public int deleteCategory(int deleteId) {
		Connection connection = DatabaseManager.GetConnection();
		int res = 0;
		try {
			Statement statement = connection.createStatement();
			String query = "DELETE FROM categories WHERE id ="+deleteId;
			
			res = statement.executeUpdate(query);
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
		
		return res;
	}

	public List<Category> getAllPublishedCategories() {
		// TODO Auto-generated method stub
		List<Category> publishedCategories = new ArrayList<Category>();
		Connection connection = DatabaseManager.GetConnection();
		
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM categories WHERE status = 1";
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				Category category = new Category();
				category.setCategoryId(resultSet.getInt("id"));
				category.setCategoryName(resultSet.getString("categoryname"));
				category.setShortDescription(resultSet.getString("categorydescription"));
				category.setPublicationStatus(resultSet.getInt("status"));
				
				publishedCategories.add(category);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return publishedCategories;
	}

}
