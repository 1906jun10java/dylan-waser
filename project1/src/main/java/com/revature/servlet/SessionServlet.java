package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;

@WebServlet("/session")
public class SessionServlet extends HttpServlet{
	//return a JSON representation of the currently authenticated user for this
	//JSESSIONID
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HIT FROM THE SESSIONSERVLET");
		HttpSession session = req.getSession(false);
		if(session != null && session.getAttribute("employeeID") != null) {
			try
			{
				int employeeID = Integer.parseInt(session.getAttribute("employeeID").toString());
				String firstname = session.getAttribute("firstname").toString();
				String lastname = session.getAttribute("lastname").toString();
				String email = session.getAttribute("email").toString();
				String username = session.getAttribute("username").toString();
				String password = session.getAttribute("passw0rd").toString();
				int managerID = Integer.parseInt(session.getAttribute("managerID").toString());
				Employee e = new Employee(employeeID, firstname, lastname, email, username, password, managerID);
				resp.getWriter().write((new ObjectMapper()).writeValueAsString(e));
			}
			catch(Exception e)
			{
				System.out.println("EXCEPTION BEING THROWN");
				e.printStackTrace();
			}
		}
		else
		{
			resp.getWriter().write("{\"session\":null}");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
