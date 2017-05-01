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

/*Controller class 
 * for User Profile page*/
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

	//Method for fetching user details for valid user name
	@ResponseBody
	@RequestMapping(value="/fetchUserDetails", method=RequestMethod.GET)
	public UserProfile fetchUserDetails(){
		
		String userName = (String)session.getAttribute("user_name");
		String sql = "SELECT * FROM user_profile where user_name=?;";
		
		this.setUserProfile(this.getJdbcTemplate().queryForObject(sql, new Object[]{userName}, new UserRowMapper()));
		
		return userProfile;
		
	}
	
	@RequestMapping(value="/userProfilePage", method=RequestMethod.GET)
	public String userProfilePage(){
		return "success";
	}
	
	//Method to save changes made by user to profile information to the database
	@RequestMapping(value="/updateUserDetails", method=RequestMethod.POST)
	public String updateUserDetails(String addressline1, String addressline2, String state, String zip, String phone){
		String userName = (String)session.getAttribute("user_name");
		this.jdbcTemplate.update("update user_profile set address_line1 =?, Address_Line2 = ?, state =?, zip =?, Phone_Number = ? where User_Name = ?", new Object[]{addressline1,addressline2,state,zip,phone,userName});
		return "success";
	}

}
