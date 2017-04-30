package com.project.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.model.UserSched;

public class UserSchedMapper implements RowMapper<UserSched> {

	@Override
	public UserSched mapRow(ResultSet rs, int arg1) throws SQLException {
		
		UserSched userSched = new UserSched();
		
		userSched.setId(rs.getInt("Id"));
		userSched.setShiftType(rs.getString("Shift_Type"));
		userSched.setUserName(rs.getString("User_Name"));
		userSched.setWeekDay(rs.getString("Week_Day"));
		userSched.setWeekNumber(rs.getInt("Week_NUmber"));
		
		return userSched;
	}

}
