package com.toufiq.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.io.*;
import java.text.SimpleDateFormat;

import com.toufiq.BLL.BlogManager;
import com.toufiq.BLL.CategoryManager;
import com.toufiq.Model.Blog;
import com.toufiq.Model.Category;

/**
 * Servlet implementation class BlogController
 */
public class BlogController extends HttpServlet {
	private CategoryManager myCategoryManager = new CategoryManager();
	private BlogManager myBlogManager = new BlogManager();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		if (request.getParameterMap().containsKey("req")) {
			String path = request.getParameter("req").toString().trim();
			if (path.equals("addblog")) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/addBlog.jsp");
				List<Category> publishedCategories = myCategoryManager.getAllPublishedCategories();
				request.setAttribute("publishedCategories", publishedCategories);
				requestDispatcher.forward(request, response);
				// response.sendRedirect("admin/addcategory.jsp");
			} else if (path.equals("manageblog")) {

				List<Blog> allBlogs = myBlogManager.getAllBlog();

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/manageblog.jsp");
				request.setAttribute("allblogs", allBlogs);
				requestDispatcher.forward(request, response);
			}
		}
		else if (request.getParameterMap().containsKey("edit")) {
			int editId = Integer.parseInt(request.getParameter("edit").toString());
			Blog blog = myBlogManager.getABlog(editId);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/editblog.jsp");

			request.setAttribute("editBlog", blog);
			requestDispatcher.forward(request, response);
		}
		else if(request.getParameterMap().containsKey("delete")) {
			int deleteId = Integer.parseInt(request.getParameter("delete").toString().trim());
			Blog deleteblog = myBlogManager.getABlog(deleteId);
			
			if(isImageDeleted(deleteblog.getImagePath())) {
				if(myBlogManager.isBLogDeleted(deleteId)) {
					List<Blog> allBlogs = myBlogManager.getAllBlog();

					RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/manageblog.jsp");
					request.setAttribute("allblogs", allBlogs);
					requestDispatcher.forward(request, response);
				}
				else {
					 out.println("canot delete the blog");
				}
			}
			else {
				out.println("Can't Delete Image");
			}
		}
		else {
			out.println("Unabaiable Request");
		}
	}

		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		

		ServletFileUpload myServletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
		if(myServletFileUpload.isMultipartContent(request)){
			List<FileItem> myfiles;
			try {
				myfiles = myServletFileUpload.parseRequest(request);
				String operationName = myfiles.get(6).getString().trim();
				if (operationName.equals("addblog")) {
	
					if (myfiles.get(4).getFieldName().equals("blogimage")) {
						
						String blogTitle = myfiles.get(0).getString();
						String categoryId = myfiles.get(1).getString();
						String shortDescription = myfiles.get(2).getString().trim();
						String longDescription = myfiles.get(3).getString().trim();
						String publicationStatus = myfiles.get(5).getString().trim();
	
						if (isValidExtension(myfiles.get(4).getName())) {
							String path = uploadFile(myfiles.get(4), blogTitle);
							
							Blog myBlog = new Blog(blogTitle, Integer.parseInt(categoryId), shortDescription, longDescription, path,Integer.parseInt(publicationStatus));
							
							if(myBlogManager.isInserted(myBlog)) {
								List<Blog> allBlogs = myBlogManager.getAllBlog();

								RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/manageblog.jsp");
								request.setAttribute("allblogs", allBlogs);
								requestDispatcher.forward(request, response);
							}
							else {
								out.println("Not Inserted");
							}
						} else {
							out.println("Not valid Extension");
						}
	
					}
	
				}
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				out.println("File Upload Exception");
				e.printStackTrace();
			}
	
			catch (Exception e) {
				out.println("File Not Exception");
				e.printStackTrace();
			}
		}
		else {
			int id = Integer.parseInt(request.getParameter("blogid").trim());
			String blogTitle = request.getParameter("blogtitle").trim();
			String shortDescription = request.getParameter("shortdescription").trim();
			String longDescription = request.getParameter("longdescription").trim();
			int publicationStatus = Integer.parseInt(request.getParameter("status").trim());
			
			Blog aUpdateBlog = new Blog(id,blogTitle,shortDescription,longDescription,publicationStatus);
			
			if(myBlogManager.isUpdated(aUpdateBlog)) {
				List<Blog> allBlogs = myBlogManager.getAllBlog();

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/manageblog.jsp");
				request.setAttribute("allblogs", allBlogs);
				requestDispatcher.forward(request, response);
			}
			else {
				out.println("Not Updated");
			}
			
			
		}
	}

	/*
	 * if(buttonName.equals("addblog")) {
	 * 
	 * try { uploadFile(request); out.println("uploades"); }catch (Exception e) { //
	 * TODO: handle exception out.println("Not  uploades");
	 * 
	 * }
	 * 
	 * out.println(blogTitle); out.println(categoryId);
	 * out.println(shortdescription); out.println(longdescription);
	 * out.println(publicationstatus); }
	 */

	private String uploadFile(FileItem aFile, String blogtitle) throws Exception {

		// String uploadPath = getServletContext().getRealPath("") + "blogimg\\";
		String uploadPath = "E:\\eclipse-workspace\\SimpleBlog\\src\\main\\webapp\\resource\\blogimg\\";
		File uploadDir = new File(uploadPath);

		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		aFile.write(new File(uploadPath + aFile.getName()));
		File myFile = new File(uploadPath + aFile.getName());
		String fileName = aFile.getName();
		String ex = getExtension(fileName);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		
		File renameFile = new File(uploadPath + timeStamp.toString().trim() + ex);
		myFile.renameTo(renameFile);
		System.out.println("Uploaded");
		return timeStamp.toString().trim() + ex;

	}

	private String getExtension(String name) {
		return name.substring(name.indexOf("."), name.length());
	}

	private boolean isValidExtension(String name) {
		String extension = getExtension(name);

		if (extension.equals(".jpg") || extension.equals(".png")) {

			return true;
		}

		return false;
	}
	
	private boolean isImageDeleted(String imagePath) {
		File file = new File("E:\\eclipse-workspace\\SimpleBlog\\src\\main\\webapp\\resource\\blogimg\\"+imagePath);
		if(file.delete()) {
			return true;
		}
		return false;
	}

}
