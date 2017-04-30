package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;

/*Controller class 
 * for loading the main page*/
@Controller
public class MainController {
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	

}
