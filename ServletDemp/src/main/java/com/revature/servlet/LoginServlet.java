package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Credentials;
import com.revature.beans.User;
import com.revature.service.AuthenticationService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private AuthenticationService authService = new AuthenticationService();
	
	//servlets should have ONLY code related to handling the requests and formatting responses
	// all application logic should be occuring in service classes
	
	/*
	 * doGet: this method will handle all GET requests made to this servlet
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//write a message to the response body with PrintWriter
		//resp.getWriter().write("hello from Login Servlet!");
		
		//serve the Login.html page as the response
		//reqeust dispatcher is used to perform a 'forward' - passing request to another resource witout the client's awareness
		req.getRequestDispatcher("Login.html").forward(req, resp);
	}
	
	/*
	 * doPost; this method with handle all POST requests made to this servlet
	 */
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//check whether a session already exists, and create one if not
		//overloaded version takes a boolean parameter, if false returns null when no session exists for the incoming request
		HttpSession session = req.getSession();
		
		
		// grab credentials from request
		Credentials creds = new Credentials(req.getParameter("username"), req.getParameter("password"));
		User u = authService.authenticateUser(creds);
		if (u != null) {
			//set user information as session attributes (not request attributes)
			session.setAttribute("userId", u.getId());
			session.setAttribute("username", u.getUsername());
			session.setAttribute("firstname", u.getFirstname());
			session.setAttribute("lastname", u.getLastname());
			session.setAttribute("email", u.getEmail());
			session.setAttribute("problem", null);
			
			
			//resp.getWriter().write("welcome, "+u.getFirstname()+ " " +u.getLastname());
			//redirect user to their profile page if authenticated
			resp.sendRedirect("profile");
			
		} else {
			//what if the creds are wrong?
			
			session.setAttribute("problem", "invalid credntials");
			
			//Option 1
			//resp.getWriter().write("invalid credentials");
			//print sassy message if wrong
			
			//what if the creds are wrong?
			//Option 2: redirect back to login
			resp.sendRedirect("login");
			
			//Option 3: send back a status code of forbidden access 403
			//TO BE CONTINUED... WHAT IF THERES AN ERROR PAGE
			//resp.sendError(403, "invalid credentials");
		}
	}
}
