package com.ebergstein.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@RequestMapping("/")
	public String welcome(@RequestParam(value = "name", required = false, defaultValue = "Human") String searchQuery, Model model){
		model.addAttribute("name", searchQuery);
		return "index.jsp";
	}

}
