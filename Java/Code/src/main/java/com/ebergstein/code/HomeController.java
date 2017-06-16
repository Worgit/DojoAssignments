package com.ebergstein.code;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String welcome(){
		return "index.jsp";
	}
	@RequestMapping("/secret")
	public String secret(@RequestParam(value = "input") String input, RedirectAttributes redirectAttributes){
		if(input.equals("bushido")){
			return "secret.jsp";
		}
		else{
			redirectAttributes.addFlashAttribute("error", "You must train harder!");
			return "redirect:/";
		}
	}
}
