package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.daoimpl.ReimbursementDAOImpl;

/**
 * Servlet implementation class SubmitRequest
 */
public class SubmitRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession(false);
		
		if(session != null) {
			response.sendRedirect("profile");
		}
		else {
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IVE HIT THE SUBMITREQUESTSERVLET");
		session = request.getSession(false);
		ReimbursementDAOImpl rdi = new ReimbursementDAOImpl();
		
		if(session != null) {
			String sEmployeeID = session.getAttribute("employeeID").toString();
			String sAmount = request.getParameter("amount");
			String sReason = request.getParameter("reason");
			String photo = request.getParameter("photo");
			
			int employeeID = Integer.parseInt(sEmployeeID);
			double amount = Double.parseDouble(sAmount);
			

			boolean test = false;
			try {
				test = rdi.createReimbursement(employeeID, amount, sReason, photo, 0);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(test == true) {
				response.setStatus(200);
				response.sendRedirect("profile");
			}
			else {
				response.sendError(403);
				response.sendRedirect("profile");
			}
		}
		else {
			response.sendRedirect("login");
		}
	}

}
