package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutUsController {
	
	@RequestMapping(value="/aboutUs")
	public String aboutUs(){
		return "aboutus";
	}
}
