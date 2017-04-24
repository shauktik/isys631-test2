package com.project.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("session")
public class ScheduleController {
	

	@RequestMapping(value="/mySchedule")
	public String loadMySchedule(){
		return "sched";
	}
	

}
