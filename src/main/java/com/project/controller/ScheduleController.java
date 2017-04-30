package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.mapper.UserSchedMapper;
import com.project.model.UserSched;

/*Controller page 
 * to load user schedule*/
@Controller
@Scope("session")
public class ScheduleController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	UserSched userSched;
	
	List<UserSched> userSchedList;
	
	
	public List<UserSched> getUserSchedList() {
		return userSchedList;
	}

	public void setUserSchedList(List<UserSched> userSchedList) {
		this.userSchedList = userSchedList;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public UserSched getUserSched() {
		return userSched;
	}

	public void setUserSched(UserSched userSched) {
		this.userSched = userSched;
	}

	//Method to load render user schedule 
	@RequestMapping(value="/mySchedule")
	public String loadMySchedule(){
		return "sched";
	}
	
	//Method to fetch user schedule information based on currently active set of weeks
	@ResponseBody
	@RequestMapping(value="/userSchedule", method=RequestMethod.GET)
	public List<UserSched> fetchUserSchedule(@RequestParam int week1, @RequestParam int week2){
		//String userName = (String)session.getAttribute("user_name");
		String userName = "shauktik@tamu.edu";
		String sqlWeek = "SELECT * from User_Sched where User_Name=? and Week_Number = ? or ?";
		this.setUserSchedList(this.getJdbcTemplate().query(sqlWeek, new Object[]{userName,week1, week2}, new UserSchedMapper()));
		
		return userSchedList;
	}
}
