package com.project.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.model.UserSched;

/*Mapper class to map retrieved
 *  user schedule information
 *   to a User Schedule bean*/
public class UserSchedRowMapper implements RowMapper<UserSched>{ {

}

@Override
public UserSched mapRow(ResultSet rs, int arg1) throws SQLException {
	
	UserSched userSched = new UserSched();
	userSched.setId(rs.getInt("ID"));
	
	
	return userSched;
}

	
}
