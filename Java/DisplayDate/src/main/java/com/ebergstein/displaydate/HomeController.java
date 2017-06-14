package com.ebergstein.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String welcome(){
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String dateGet(Model model){
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE 'the' dd 'of' MMMM, yyyy");
		String result = formatter.format(date);
		model.addAttribute("date", result);
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String timeGet(Model model){
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("K:mm a");
		String result = formatter.format(date);
		model.addAttribute("time", result);
		return "time.jsp";
	}
}
