package com.revature.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;
import com.revature.daoimpl.ReimbursementDAOImpl;

@WebServlet("/readRequests")
public class ReadReimbursementServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	ObjectMapper mapper = new ObjectMapper();
	ReimbursementDAOImpl rdi = new ReimbursementDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session = req.getSession(false);
		if(session != null && session.getAttribute("employeeID") != null)
		{
			try {
				int employeeID = Integer.parseInt(session.getAttribute("employeeID").toString());
				ArrayList<Reimbursement> empReimbursementList = rdi.readReimbursementByEmpID(employeeID);
				resp.getWriter().write((new ObjectMapper()).writeValueAsString(empReimbursementList));
			}
			catch(Exception e)
			{
				
			}
		}
		else
		{
			resp.sendRedirect("/login");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
