package com.toufiq.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toufiq.BLL.CategoryManager;
import com.toufiq.Model.Category;

/**
 * Servlet implementation class CategoryController
 */
public class CategoryController extends HttpServlet {
	private CategoryManager myCategoryManager = new CategoryManager();

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

			if (path.equals("addcategory")) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/addcategory.jsp");
				requestDispatcher.forward(request, response);
				// response.sendRedirect("admin/addcategory.jsp");
			} else if (path.equals("managecategory")) {
				List<Category> allCategories = myCategoryManager.getAllCategories();

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/managecategory.jsp");

				request.setAttribute("categories", allCategories);
				requestDispatcher.forward(request, response);
				// response.sendRedirect("admin/managecategory.jsp");
			}
		}

		if (request.getParameterMap().containsKey("edit")) {
			int editId = Integer.parseInt(request.getParameter("edit").toString());
			Category editCategory = myCategoryManager.getCategoryByCategoryId(editId);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/editcategory.jsp");

			request.setAttribute("editcategory", editCategory);
			requestDispatcher.forward(request, response);
		}
		if(request.getParameterMap().containsKey("delete")) {
			int deleteId = Integer.parseInt(request.getParameter("delete").toString());
			
			if(myCategoryManager.deleteCategory(deleteId)) {
				List<Category> allCategories = myCategoryManager.getAllCategories();

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/managecategory.jsp");

				request.setAttribute("categories", allCategories);
				requestDispatcher.forward(request, response);
			}
			else {
				out.println("Not Deleted");
			}
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
		String catagoryName = request.getParameter("categoryname").toString().trim();
		String shortdescription = request.getParameter("shortdescription").toString().trim();
		int publicationstatus = Integer.parseInt(request.getParameter("status").toString());
		String buttonName = request.getParameter("operationbtn").toString().trim();
		
		if(buttonName.equals("addcatgeory")) {
			Category aCategory = new Category(catagoryName, shortdescription, publicationstatus);

			

			if (myCategoryManager.insertCategory(aCategory)) {
				List<Category> allCategories = myCategoryManager.getAllCategories();

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/managecategory.jsp");

				request.setAttribute("categories", allCategories);
				requestDispatcher.forward(request, response);
			} else {
				out.println("Not inserted");
			}
		}
		else if (buttonName.equals("update")) {
			int categoryId = Integer.parseInt(request.getParameter("categoryid").toString());
			Category aCategory = new Category(categoryId, catagoryName, shortdescription, publicationstatus);
			
			if(myCategoryManager.updateCategory(aCategory)) {
				List<Category> allCategories = myCategoryManager.getAllCategories();

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/managecategory.jsp");

				request.setAttribute("categories", allCategories);
				requestDispatcher.forward(request, response);
			}
			else {
				out.println("Not Updated");
			}
					

		}
		

	}

}
