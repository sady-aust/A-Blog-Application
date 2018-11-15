package com.toufiq.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.toufiq.BLL.AdminManager;
import com.toufiq.Model.Admin;

/**
 * Servlet implementation class AdminLoginController
 */
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminManager myAdminManager = new AdminManager();
       
  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email").toString().trim();
		String password = request.getParameter("password").toString().trim();
		Admin aAdmin = myAdminManager.getAdmin(new Admin(email, password));
		PrintWriter out	= response.getWriter();
		
		if(aAdmin!=null) {
			HttpSession session= request.getSession();
			session.setAttribute("admin", aAdmin);
			response.sendRedirect("admin/adminpannel.jsp");
			
					
		}
		else {
			out.println("Not found");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("logout").toString().trim().equals("true")) {
			HttpSession session= request.getSession();
			session.setAttribute("admin", null);
			response.sendRedirect("admin/index.jsp");
		}
	}


}
