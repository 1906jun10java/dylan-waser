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

import com.revature.beans.Employee;
import com.revature.daoimpl.EmployeeDAOImpl;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet{
	
	private EmployeeDAOImpl edi = new EmployeeDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("HIT FROM THE PROFILE SERVLET");
		HttpSession session = req.getSession(false);
		if(session != null)
		{
			boolean isManager = false;
			ArrayList<Employee> empList = null;
			try {
				empList = edi.readAllEmployees();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(empList != null)
			{
				for(int i = 0; i < empList.size(); i++)
				{
					if((int) session.getAttribute("employeeID") == empList.get(i).getManagerID())
					{
						isManager = true;
					}
				}
				if(isManager)
				{
					resp.setStatus(200);
					resp.sendRedirect("ManagerProfile.html");
				}
				else {
					resp.setStatus(200);
					resp.sendRedirect("Profile.html");
				}
			}
		}
		else
		{
			resp.sendRedirect("login");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
