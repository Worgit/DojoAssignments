package com.ebergstein.calculator.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ebergstein.calculator.models.Calculator;

/**
 * Servlet implementation class Calculator
 */
//@WebServlet("/Calculator")
public class Calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("Calculator.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println(request.getParameter("character"));
		if(request.getParameter("character").equals("c") == true){
			HttpSession session = request.getSession();
			session.removeAttribute("calculation");
			//session.removeAttribute("calcmap");
			RequestDispatcher view = request.getRequestDispatcher("Calculator.jsp");
	        view.forward(request, response);
		}
		else if(request.getParameter("character").equals("=") == false){
			//System.out.println("here");
			//response.sendRedirect("/Calculator/calculator");
			HttpSession session = request.getSession();
			//System.out.println(request.getParameter("character"));
			String calculation = (String) session.getAttribute("calculation");
			//System.out.println(calculation);
			if(calculation == null){
				calculation = request.getParameter("character");
			}
			else{
				calculation = calculation.concat(request.getParameter("character"));
			}
			//System.out.println(calculation);
			session.setAttribute("calculation", calculation);
			//System.out.println(session.getAttribute("calculation"));
			/*HashMap <String, String> calcmap = (HashMap<String, String>) session.getAttribute("calcmap");
			if(calcmap == null){
				calcmap = new HashMap<>();
			}
			String calculation = (String) session.getAttribute("calculation");
			//System.out.println(calculation);
			if(calculation == null){
				calculation = request.getParameter("character");
				calcmap.put(calculation, calculation);
			}
			else{
				String character = request.getParameter("character");
				if(character.equals(" + ")){
					character = " &#43; ";
				}
				else if(character.equals(" - ")){
					character = " &#45; ";
				}
				else if(character.equals(" * ")){
					character = " &#42; ";
				}
				else if(character.equals(" / ")){
					character = " &#47; ";
				}
				String calctemp;
				if(calcmap.size() == 0){
					calctemp = calculation.concat(character);
				}
				else{
					calctemp = calcmap.get(calculation).concat(character);
				}
				calculation = calculation.concat(request.getParameter("character"));
				calcmap.put(calculation, calctemp);
				System.out.println(calcmap.get(calculation));
			}
			
			session.setAttribute("calculation", calculation);
			session.setAttribute("calcmap", calcmap);*/
	        RequestDispatcher view = request.getRequestDispatcher("Calculator.jsp");
	        view.forward(request, response);
		}
		else{
			HttpSession session = request.getSession();
			//String calculation = (String) session.getAttribute("calculation");
			String calculation = (String) request.getParameter("calculation");
			//String temp = (String) request.getAttribute("calculation");
			//String[] calculation = temp.split(" ");
			//System.out.println(calculation);
			Calculator calculator = new Calculator();
			calculator.update(calculation);
			String result = calculator.calculate();
			//System.out.println(result);
			if(result.equals(null) == false){
				System.out.println(result);
				ArrayList<Integer> previous = (ArrayList<Integer>) session.getAttribute("previous");
				if(previous == null){
					previous = new ArrayList<>();
				}
				System.out.println(previous);
				previous.add(Integer.parseInt(result));
				System.out.println(previous);
				session.setAttribute("previous", previous);
			}
			session.removeAttribute("calculation");
			session.removeAttribute("calcmap");
			RequestDispatcher view = request.getRequestDispatcher("Calculator.jsp");
			view.forward(request, response);
		}
	}

}
