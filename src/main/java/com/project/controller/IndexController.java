package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*Controller class 
 * for loading main page*/
@Controller
@RequestMapping("/index")
public class IndexController {
	
	 
	@RequestMapping(method=RequestMethod.GET)
	public String index(){
		return "index";
	}

}
