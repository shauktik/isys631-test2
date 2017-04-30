package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*Controller class 
 * for Contact Us page*/
@Controller
public class ContactUsController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	//Method used to render Contact Us page to the user
	@RequestMapping(value="/contact")
	public String contactUs(){
		return "contact";
	}
	
	//Method to submit a general query to the website admin
	@RequestMapping(value="/submitQuery", method=RequestMethod.POST)
	public String contactUs(String firstName, String lastName, String emailId, String phone, String comment){
		
		if(phone==null) phone="XX-XX-XX";
		
		this.getJdbcTemplate()
		.update("Insert into user_contact_admin(first_name,last_name,email_id,phone_number,user_message) values(?,?,?,?,?)", new Object[]{firstName, lastName,emailId,phone,comment});
		return "contact";
		
	}
}
