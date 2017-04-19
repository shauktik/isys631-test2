package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("session")
public class TimesheetController {
	
	@Autowired
	HttpSession session;
	
	
	
	
	@RequestMapping(value="/timesheets")
	public String loadTimesheet(){
		return "timesheet";
	}

}
