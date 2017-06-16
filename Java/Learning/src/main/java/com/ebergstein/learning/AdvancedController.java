package com.ebergstein.learning;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdvancedController {
	@RequestMapping("/m/26/0553/{lesson}")
	public String advrequest(@PathVariable String lesson, Model model){
		if(lesson.equals("0348")){
				model.addAttribute("content", "Advanced Fortran Intro");
		}
		else{
			model.addAttribute("content", "Fortran to Binary");
		}
		return "0553_content.jsp";
	}
}
