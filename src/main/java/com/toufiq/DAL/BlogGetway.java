package com.toufiq.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.toufiq.Model.Blog;
import com.toufiq.Model.Category;

public class BlogGetway {
	public BlogGetway() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch (ClassNotFoundException  e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public int insertBlog(Blog aBlog) {
		Connection connection = DatabaseManager.GetConnection();
		int res = 0;
		try {
			Statement statement = connection.createStatement();
			String query = "INSERT INTO blogs (categoryid,shortdescription,longdescription,status,title,imgpath) VALUES(?,?,?,?,?,?)";
			
			PreparedStatement myPreparedStatement = connection.prepareStatement(query);
			myPreparedStatement.setInt(1, aBlog.getCategoryId());
			myPreparedStatement.setString(2, aBlog.getShortDescription());
			myPreparedStatement.setString(3, aBlog.getLongDescription());
			myPreparedStatement.setInt(4, aBlog.getPublicationStatus());
			myPreparedStatement.setString(5, aBlog.getBlogTitle());
			myPreparedStatement.setString(6, aBlog.getImagePath());
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
	
	public List<Blog> getAllBlog(){
		List<Blog> blogs = new ArrayList<Blog>();
		Connection connection = DatabaseManager.GetConnection();
		
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT blogs.*,categories.categoryname From blogs INNER JOIN categories ON  blogs.categoryid = categories.id";
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				Blog ablog = new Blog();
				ablog.setBlogId(resultSet.getInt("id"));
				ablog.setBlogTitle(resultSet.getString("title"));
				ablog.setCategoryId(resultSet.getInt("categoryid"));
				ablog.setImagePath(resultSet.getString("imgpath"));
				ablog.setShortDescription(resultSet.getString("shortdescription"));
				ablog.setLongDescription(resultSet.getString("longdescription"));
				ablog.setPublicationStatus(resultSet.getInt("status"));
				ablog.setCategoryName(resultSet.getString("categoryname"));
				
				blogs.add(ablog);
				
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
		
		return blogs;
	}	

	public Blog getABLog(int editId) {
		List<Blog> blogs = new ArrayList<Blog>();
		Connection connection = DatabaseManager.GetConnection();
		
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT blogs.*,categories.categoryname From blogs INNER JOIN categories ON  blogs.categoryid = categories.id WHERE blogs.id ="+editId;
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				Blog ablog = new Blog();
				ablog.setBlogId(resultSet.getInt("id"));
				ablog.setBlogTitle(resultSet.getString("title"));
				ablog.setCategoryId(resultSet.getInt("categoryid"));
				ablog.setImagePath(resultSet.getString("imgpath"));
				ablog.setShortDescription(resultSet.getString("shortdescription"));
				ablog.setLongDescription(resultSet.getString("longdescription"));
				ablog.setPublicationStatus(resultSet.getInt("status"));
				ablog.setCategoryName(resultSet.getString("categoryname"));
				
				blogs.add(ablog);
				
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
		
		if(blogs.size()>0) {
			return blogs.get(0);
		}
		return null;
	}

	public int updateBlog(Blog aUpdateBlog) {
		Connection connection = DatabaseManager.GetConnection();
		int res = 0;
		try {
			Statement statement = connection.createStatement();
			String query = "UPDATE blogs SET title ='"+aUpdateBlog.getBlogTitle()+"',shortdescription='"+aUpdateBlog.getShortDescription()+"',longdescription='"+aUpdateBlog.getLongDescription()+"',status="+aUpdateBlog.getPublicationStatus()+" WHERE id ="+aUpdateBlog.getBlogId();
			
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

	public int deleteBlog(int deleteId) {
		Connection connection = DatabaseManager.GetConnection();
		int res = 0;
		try {
			Statement statement = connection.createStatement();
			String query = "DELETE FROM blogs WHERE id ="+deleteId;
			
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
}
