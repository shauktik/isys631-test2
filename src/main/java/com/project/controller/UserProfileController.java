package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.mapper.UserRowMapper;
import com.project.model.UserProfile;

@Controller
@Scope("session")
public class UserProfileController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	HttpSession session;
	
	UserProfile userProfile;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	


	public UserProfile getUserProfile() {
		return userProfile;
	}


	@ResponseBody
	@RequestMapping(value="/fetchUserDetails", method=RequestMethod.GET)
	public UserProfile fetchUserDetails(){
		
		System.out.println("User Profile Controller Called");
		String userName = (String)session.getAttribute("user_name");
		System.out.println("Session user name::"+userName);
		String sql = "SELECT * FROM user_profile where user_name=?;";
		
		this.setUserProfile(this.getJdbcTemplate().queryForObject(sql, new Object[]{userName}, new UserRowMapper()));
		
		return userProfile;
		
	}

}
