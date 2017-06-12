package com.ebergstein.timer.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ebergstein.timer.models.Timer;

/**
 * Servlet implementation class EndTimer
 */
//@WebServlet("/EndTimer")
public class StopWatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StopWatch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String input = request.getParameter("type");
		System.out.println(input);
		if(input.equals("start")){
				Timer timer = new Timer();
				System.out.println("mace it 2");
				session.setAttribute("timer", timer);
				if(session.getAttribute("timers") == null){
					ArrayList<Timer> timers = new ArrayList<>();
					session.setAttribute("timers", timers);
				}
		}
		else if(input.equals("reset")){
			System.out.println("mace it3");
			session.removeAttribute("timer");
		}
		else if (input.equals("stop")){
			System.out.println("mace it 4");
			Timer timer = (Timer) session.getAttribute("timer");
        	timer.end();
        	// Set Model for view
        	session.removeAttribute("timer");
        	ArrayList<Timer> timers = (ArrayList<Timer>) session.getAttribute("timers");
        	timers.add(timer);
        	session.setAttribute("timers", timers);
		}
        // Let view handle the request
        RequestDispatcher view = request.getRequestDispatcher("stopwatch.jsp");
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
