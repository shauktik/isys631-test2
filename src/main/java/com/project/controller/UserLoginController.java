package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*Controller class 
 * for User Login*/
@Controller
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
	
	//Method to authenticate user against entered credentials
	@RequestMapping(value="/UserProfile", method=RequestMethod.POST)
	public String checkCredentials(String userName, String password){
		
		//JDBCTemplate code and query to search for username and password combination in database
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
