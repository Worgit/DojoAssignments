package com.ebergstein.learning;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicController {
	@RequestMapping("/m/38/{path}/{lesson}")
	public String request(@PathVariable String path, @PathVariable String lesson, Model model){
		if(path.equals("0483")){
			if(lesson.equals("0733")){
					model.addAttribute("content", "Setting up your servers");
			}
			else{
				model.addAttribute("content", "Coding Forms");
			}
			return "basic_content.jsp";
		}
		else{
			model.addAttribute("content", "Punch Cards");
			return "0485_content.jsp";
		}
	}
}
