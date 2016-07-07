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
	
	@RequestMapping("/about")
	public String home(Model model)
	{
		return "aboutus.html";
	}
}
