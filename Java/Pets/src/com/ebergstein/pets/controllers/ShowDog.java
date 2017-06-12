package com.ebergstein.pets.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebergstein.pets.models.Dog;

/**
 * Servlet implementation class ShowDog
 */
//@WebServlet("/ShowDog")
public class ShowDog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String breed = request.getParameter("breed");
        int weight = Integer.parseInt(request.getParameter("weight"));
        // Create model
        Dog dog = new Dog(name, breed, weight);
        //System.out.println(dog.showAffection());
        // Set Model for view
        request.setAttribute("dog", dog);
        // Let view handle the request
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/showDog.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
