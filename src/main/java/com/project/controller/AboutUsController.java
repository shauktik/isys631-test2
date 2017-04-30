package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*Controller class 
 * for About Us page*/

@Controller
public class AboutUsController {
	
	//Method used to render About Us static page
	@RequestMapping(value="/aboutUs")
	public String aboutUs(){
		return "aboutus";
	}
}
