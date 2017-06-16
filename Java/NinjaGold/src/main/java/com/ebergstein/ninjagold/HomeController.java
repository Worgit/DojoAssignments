package com.ebergstein.ninjagold;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String welcome(HttpSession session){
		Integer gold = (Integer) session.getAttribute("gold");
		if(gold == null){
			gold = 0;
		}
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		if(activities == null){
			activities = new ArrayList<>();
		}
		return "index.jsp";
	}
	@RequestMapping(path = "/gold", method = RequestMethod.POST)
	public String farm(@RequestParam(value = "type") String type, HttpSession session){
		Integer gold = (Integer) session.getAttribute("gold");
		if(gold == null){
			gold = 0;
		}
		Random generator = new Random();
		int result = 0;
		if(type.equals("farm")){
			result = generator.nextInt(10) + 10;
		}
		else if(type.equals("cave")){
			result = generator.nextInt(5) + 5;
		}
		else if(type.equals("house")){
			result = generator.nextInt(3) + 2;
		}
		else{
			result = generator.nextInt(100) - 50;
		}
		gold += result;
		session.setAttribute("gold", gold);
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		if(activities == null){
			activities = new ArrayList<>();
		}
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MMMM d YYYY K:mm a");
		activities.add("You entered a farm and earned " + result + " gold. (" + format.format(date) + ")");
		session.setAttribute("activities", activities);
		return "redirect:/";
	}
}
