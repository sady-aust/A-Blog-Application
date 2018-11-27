package com.toufiq.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toufiq.BLL.BlogManager;
import com.toufiq.BLL.CategoryManager;
import com.toufiq.Model.Blog;
import com.toufiq.Model.Category;

/**
 * Servlet implementation class HomeController
 */
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogManager myBlogManager = new BlogManager();
	private CategoryManager myCategoryManager = new CategoryManager();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameterMap().containsKey("blogId")) {
			int blogId = Integer.parseInt(request.getParameter("blogId").toString());

			RequestDispatcher myRequestDispatcher = request.getRequestDispatcher("Home/blogdetails.jsp");
			Blog aBlog = myBlogManager.getABlog(blogId);

			request.setAttribute("blog", aBlog);
			myRequestDispatcher.forward(request, response);
		} else if (request.getParameterMap().containsKey("categoryId")) {
			int categoryId = Integer.parseInt(request.getParameter("categoryId").toString());

			RequestDispatcher myRequestDispatcher = request.getRequestDispatcher("Home/home.jsp");
			List<Blog> publishedBlogs = myBlogManager.getAllPublishedBlogOfACategory(categoryId);
			List<Category> publishedCategories = myCategoryManager.getAllPublishedCategories();

			request.setAttribute("blogs", publishedBlogs);
			request.setAttribute("categories", publishedCategories);
			myRequestDispatcher.forward(request, response);
		}

		else {

			RequestDispatcher myRequestDispatcher = request.getRequestDispatcher("Home/home.jsp");
			List<Blog> publishedBlogs = myBlogManager.getAllPublishedBlog();
			List<Category> publishedCategories = myCategoryManager.getAllPublishedCategories();

			request.setAttribute("blogs", publishedBlogs);
			request.setAttribute("categories", publishedCategories);
			myRequestDispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
