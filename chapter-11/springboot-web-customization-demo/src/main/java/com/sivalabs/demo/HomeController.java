/**
 * 
 */
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
		return "index";
	}
	
	@RequestMapping("/homepage")
	public String home(Model model)
	{
		return "home";
	}
	
}
