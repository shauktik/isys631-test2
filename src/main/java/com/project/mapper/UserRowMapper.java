package com.project.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.model.UserProfile;

public class UserRowMapper implements RowMapper<UserProfile>{

	@Override
	public UserProfile mapRow(ResultSet rs, int arg1) throws SQLException {
		
		
		UserProfile userProfile = new UserProfile();
		
		userProfile.setAddressline1(rs.getString("Address_Line1"));
		userProfile.setAddressline2(rs.getString("Address_Line2"));
		userProfile.setState(rs.getString("State"));
		userProfile.setZip(rs.getInt("ZIP"));
		userProfile.setDob(rs.getString("DOB"));
		userProfile.setHourlyWage(rs.getInt("Hourly_wage"));
		userProfile.setJobRole(rs.getString("Job_Role"));
		userProfile.setPhoneNumber(rs.getString("Phone_Number"));
		userProfile.setSsn(rs.getString("SSN"));
		userProfile.setLastName(rs.getString("Last_Name"));
		userProfile.setFirstName(rs.getString("First_Name"));
		
		return userProfile;
	}

}
