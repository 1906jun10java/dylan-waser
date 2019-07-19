package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.beans.Bear;
import com.revature.service.BearService;

@WebServlet("/bear") //alternate way to register and map servlets. pick this or XML and do so through the whole app
public class BearServlet extends HttpServlet{
	//this is our service class whose methods we will call
	private BearService bearService;
	
	
	//create object mapper, use this to convert java objects to JSON-formatted data to include in response bodies
	private ObjectMapper om;
	
	//bearServlet constructor
	public BearServlet() {
		bearService = new BearService();
		om = new ObjectMapper();
		om.registerModule(new JavaTimeModule());
		om.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
	}

	//return all bears, in JSON format, IF no bear id is specified. otherwise return the requested bear
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//check whether there is an id provided in the query string
		String idString = req.getParameter("id");
		if(idString != null)
		{
			//try and find the desired bear
			try {
				int id = Integer.parseInt(idString);
				String bearJSON = om.writeValueAsString(bearService.getBearByID(id));
				//if ObjectMapper gets a null value, it will be converted to a String "null"
				if(!bearJSON.equals("null"))
				{
					resp.getWriter().write(bearJSON);
				}
				else
				{
					resp.sendError(400); //bear not found exception
				}
			}
			catch(Exception e)
			{
				resp.sendError(400); //general bad request
			}
		}else {
			//otherwise return all bears
			resp.getWriter().write(om.writeValueAsString(bearService.getBears()));
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//read request body and conver to a Java object from JSON format
		if(bearService.createBear(om.readValue(req.getReader(), Bear.class)))
		{
			resp.setStatus(200);
		}
		else
		{
			resp.setStatus(400);
		}
	}

}
