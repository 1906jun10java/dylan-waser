package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.daoimpl.EmployeeDAOImpl;

@WebServlet("/viewAllEmps")
public class ReadAllEmployeesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	HttpSession session = null;
	EmployeeDAOImpl edi = new EmployeeDAOImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession(false);
		ArrayList<Employee> empsList = null;
		try {
			empsList = edi.readAllEmployees();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(empsList != null)
		{
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(empsList));
		}
	}
}
