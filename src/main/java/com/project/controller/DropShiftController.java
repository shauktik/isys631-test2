package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DropShiftController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	HttpSession session;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public HttpSession getSession() {
		return session;
	}
	
	@RequestMapping(value="/shiftdrop",  method=RequestMethod.POST)
	public String dropShiftByUserName(String dropShiftMessage){
		
		String[] dropMessage = dropShiftMessage.split(" ");
		String userName = "shauktik@tamu.edu";
		String weekNum = dropMessage[0];
		String shift = dropMessage[1];
		String optMessage = null;
		if(dropMessage[2]!=null){
			optMessage = dropMessage[2];
		}
		String weekDay = dropMessage[3];
		
		//String userName = (String) session.getAttribute("user_name");
		this.getJdbcTemplate().update
		("Insert into user_drop_shift(user_name, week_number, shift_type, reason_opt,Week_Day) values(?,?,?,?,?)",new Object[]{userName,weekNum,shift,optMessage,weekDay});
		return "sched";
	}
}
