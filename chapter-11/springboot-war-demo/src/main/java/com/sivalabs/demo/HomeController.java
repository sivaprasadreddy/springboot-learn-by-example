package com.sivalabs.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Siva
 *
 */
@Controller
public class HomeController
{
	@RequestMapping("/")
	public String index(Model model)
	{
		return "index.jsp";
	}
	
	@RequestMapping("/home")
	public String home(Model model)
	{
		model.addAttribute("content", "SpringBoot application using JSP Views");
		return "home.jsp";
	}
}
