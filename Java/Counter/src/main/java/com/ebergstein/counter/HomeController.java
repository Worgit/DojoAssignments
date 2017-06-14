package com.ebergstein.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String welcome(HttpSession session){
		Integer total = (Integer) session.getAttribute("visits");
		if(total == null){
			total = 0;
		}
		else{
			total++;
		}
		session.setAttribute("visits", total);
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String count(){
		return "counter.jsp";
	}

}
