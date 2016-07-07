/**
 * 
 */
package com.sivalabs.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Siva
 *
 */
@Controller
public class HomeController
{

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "SpringBoot + Thymeleaf rocks");
		return "index";
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(User user, Model model) {
		System.out.println("Login User: "+user);
		return "redirect:/";
	}
	
}
