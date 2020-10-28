package com.csis3275.model_cwu_18;

/**
 * 
 * @author Eduardo Peres - 300318007
 * This is the login mapper
 *
 */

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LoginMapper_epe_07 implements RowMapper<Login_epe_07>{

	@Override
	public Login_epe_07 mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Login_epe_07 login = new Login_epe_07();
		login.setEmail(rs.getString("email"));
		login.setPassword(rs.getString("password"));
		return login;
	}

}
