package com.csis3275.model_cwu_18;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper_cwu_18 implements RowMapper<User_cwu_18>{

	@Override
	public User_cwu_18 mapRow(ResultSet rs, int rowNum) throws SQLException {
		User_cwu_18 user = new User_cwu_18();
		user.setUser_id(rs.getInt("user_id"));
		user.setFirst_name(rs.getString("first_name"));
		user.setLast_name(rs.getString("last_name"));
		user.setEmail(rs.getString("email"));
		user.setAddress(rs.getString("address"));
		user.setContact_number(rs.getString("contact_number"));
		user.setPassword(rs.getString("password"));
		user.setUser_type(rs.getInt("user_type"));
		return user;
	}

}
