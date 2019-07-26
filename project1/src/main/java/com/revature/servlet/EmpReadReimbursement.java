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
import com.revature.beans.Reimbursement;
import com.revature.daoimpl.ReimbursementDAOImpl;

@WebServlet("/empReimbursements")
public class EmpReadReimbursement extends HttpServlet{

	ObjectMapper mapper = new ObjectMapper();
	ReimbursementDAOImpl rdi = new ReimbursementDAOImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		String empIDRaw = req.getParameter("id");
		int empID = Integer.parseInt(empIDRaw);
		ArrayList<Reimbursement> empReimList = null;
		try {
			empReimList = rdi.readReimbursementByEmpID(empID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(empReimList != null)
		{
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(empReimList));
		}
		else
		{
			resp.sendRedirect("/profile");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
