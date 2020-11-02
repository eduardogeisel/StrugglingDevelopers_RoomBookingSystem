package com.csis3275.model_cwu_18;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper_sho_38 implements RowMapper<User_sho_38> {

	@Override
	public User_sho_38 mapRow(ResultSet rs, int rowNum) throws SQLException {
		User_sho_38 newUser = new User_sho_38();

		// TODO Auto-generated method stub
		newUser.setUser_id(rs.getInt("user_id"));
		newUser.setFirst_name(rs.getString("first_name"));
		newUser.setLast_name(rs.getString("last_name"));
		newUser.setAddress(rs.getString("address"));
		newUser.setContact_number(rs.getString("contact_number"));
		newUser.setUser_type(rs.getInt("user_type"));
		newUser.setEmail(rs.getString("email"));
		newUser.setPassword(rs.getString("password"));
		return newUser;
	}
}
