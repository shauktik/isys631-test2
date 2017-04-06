package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("session")
public class UserLoginController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	HttpSession session;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@RequestMapping(value="/UserLoginController", method=RequestMethod.POST)
	public String checkCredentials(String userName, String password){

		String sql = "select count(*) from user_login where User_Name=? AND Password=?";
		int count = this.getJdbcTemplate().queryForObject(sql, new Object[]{userName, password}, Integer.class);
		
		
		
		if (count==1){ 
		session.setAttribute("user_name", userName);
		//System.out.println("User Name::"+userName);
		return "success";
		}

		return "index";
			
	}
	
		

}
