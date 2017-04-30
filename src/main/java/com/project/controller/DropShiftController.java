package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.mapper.UserSchedRowMapper;
import com.project.model.UserSched;

/*Controller class 
 * for Drop shift user feature */
@Controller
public class DropShiftController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	HttpSession session;
	
	UserSched userSched;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public HttpSession getSession() {
		return session;
	}
	
	
	public UserSched getUserSched() {
		return userSched;
	}
	
	public void setUserSched(UserSched userSched) {
		this.userSched = userSched;
	}

	//
	@RequestMapping(value="/shiftdrop",  method=RequestMethod.POST)
	public String dropShiftByUserName(String dropShiftMessage){
		System.out.println("Drop Shift Controller called");
		//int sched_id= 0;
		String[] dropMessage = dropShiftMessage.split(" ");
		String userName = (String)session.getAttribute("user_name");
		String weekNum = dropMessage[0];
		String shift = dropMessage[1];
		String optMessage = null;
		if(dropMessage[2]!=null){
			optMessage = dropMessage[2];
		}
		String weekDay = dropMessage[3];
		
		this.setUserSched(this.getJdbcTemplate().
				queryForObject("select ID from user_sched where user_name=? and week_number=? and week_day=? and shift_type =?",new Object[]{userName,weekNum,weekDay,shift}, new UserSchedRowMapper()));
		
		//String userName = (String) session.getAttribute("user_name");
		this.getJdbcTemplate().update
		("Insert into user_drop_shift(Reason_opt, sched_id) values(?,?)",new Object[]{optMessage,this.getUserSched().getId()});
		return "sched";
	}
}
