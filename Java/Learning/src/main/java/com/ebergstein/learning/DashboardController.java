package com.ebergstein.learning;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
	@RequestMapping("/")
	public String welcome(){
		return "index.jsp";
	}
	
	@RequestMapping("/setup")
	public String setup(){
		return "redirect:/m/38/0483/0733";
	}
	@RequestMapping("/forms")
	public String forms(){
		return "redirect:/m/38/0483/0345";
	}
	@RequestMapping("/manual")
	public String manual(){
		return "redirect:/m/38/0485/0348";
	}
	@RequestMapping("/advanced")
	public String advanced(){
		return "redirect:/m/26/0553/0348";
	}
	@RequestMapping("/binary")
	public String binary(){
		return "redirect:/m/26/0553/2342";
	}
}
