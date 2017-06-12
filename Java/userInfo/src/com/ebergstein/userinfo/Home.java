package com.ebergstein.userinfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
//@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		if(firstName == null){
			firstName = "Unknown";
		}
		String lastName = request.getParameter("lastName");
		if(lastName == null){
			lastName = "Unknown";
		}
		String language = request.getParameter("language");
		if(language == null){
			language = "Unknown";
		}
		String hometown = request.getParameter("hometown");
		if(hometown == null){
			hometown = "Unknown";
		}
		PrintWriter out = response.getWriter();
		out.write("Welcome, " + firstName + " " + lastName + "\n");
		out.write("Your favorite language is: " + language + "\n");
		out.write("Your hometown is: " + hometown);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
