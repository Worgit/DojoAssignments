package com.ebergstein.logreg.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ebergstein.logreg.models.Role;
import com.ebergstein.logreg.models.User;
import com.ebergstein.logreg.services.UserService;
import com.ebergstein.logreg.validator.UserValidator;

@Controller
public class Users {
	
    private UserService userService;
    private UserValidator userValidator;
    
    public Users(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
	
    @RequestMapping("/registration")
    public String registerForm() {
        return "redirect:/login";
    }
   
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
    	userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "index.jsp";
        }
        List<User> users = userService.getAllUsers();
        //System.out.println(users.size());
        if(users.size() == 0){
        	//System.out.println("admininit");
        	userService.saveWithUserAndAdminRole(user);
        }
        else{
        	userService.saveWithUserRole(user);
        }
//      securityService.autoLogin(user.getUsername(), user.getPasswordConfirmation());
//      session.setAttribute("user", currentUser.getId());
        return "redirect:/login";
    }
    
	@RequestMapping("/login")
	public String login(@Valid @ModelAttribute("user") User user,@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
		if(error != null) {
			//System.out.println("Came in the error");
			model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
		}
		if(logout != null) {
			//System.out.println("Came in the logut");
			model.addAttribute("logoutMessage", "Logout Successfull!");
		}
		return "index.jsp";
	}

	@RequestMapping(value = {"/", "/home"})
	public String home(Principal principal, Model model) {
		String email = principal.getName();
		//System.out.println(currentUser.getUsername());
		User user = userService.findByEmail(email);
		/*System.out.println("IN THE CONTROLLER ROLES");
		System.out.println(user.getRoles().get(0).getName());
		System.out.println(user.getRoles().get(1).getName());*/
		Role admin = userService.findRole("ROLE_ADMIN");
		//System.out.println(user.getRoles().contains(admin));
		if(user.getRoles().contains(admin)){
			//System.out.println("came in the contains admin!!!!!!!!@@@@");
			return "redirect:/admin";
		}
		userService.updateUser(user);
		model.addAttribute("user", userService.findByEmail(email));
		return "homePage.jsp";
	}
	
	@RequestMapping("/admin")
	public String adminPage(Model model, Principal principal){
		//System.out.println("admin");
		User admin = userService.findByEmail(principal.getName());
		userService.updateUser(admin);
		model.addAttribute("admin", admin);
		Role role = userService.findRole("ROLE_ADMIN");
		model.addAttribute("role", role);
		model.addAttribute("users", userService.getAllUsers());
		return("admin.jsp");
	}
	
	@RequestMapping("/user/{id}/delete")
	public String delete(@PathVariable("id") Long id){
		userService.destroyUser(id);
		return("redirect:/admin");
	}
	@RequestMapping("/user/{id}/promote")
	public String promote(@PathVariable("id") Long id){
		User user = userService.getOneUser(id);
		userService.promoteUser(user);
		return("redirect:/admin");
	}
}