package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.services.EmployeeServices;

@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet{

	HttpSession session = null;
	EmployeeServices es = new EmployeeServices();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean updated = false;
		session = req.getSession(false);
		if(session != null)
		{
			
			int empId = (int) session.getAttribute("employeeID");
			String newUsername = req.getParameter("newUsername");
			String newFirstName = req.getParameter("newFirstName");  //get parameters from the submit form
			String newLastName = req.getParameter("newLastName");
			String newEmail = req.getParameter("newEmail");
			updated = es.updateEmployee(empId, newUsername, newFirstName, newLastName, newEmail); //apply new values

			if(updated == true) {
				resp.setStatus(200);
				session.setAttribute("username", newUsername);
				session.setAttribute("firstName", newFirstName);
				session.setAttribute("lastName", newLastName);
				session.setAttribute("email", newEmail);
				resp.sendRedirect("profile");
			}
			else {
				resp.sendError(403);
				resp.sendRedirect("profile");
			}
		}
		else {
			resp.sendRedirect("login");
		}
		
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
