package com.csis3275.model_cwu;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.junit.Test;

import com.csis3275.dao_cwu_18.DAOImpl_cwu_18;
import com.csis3275.model_cwu_18.Booking_cwu_18;
import com.csis3275.model_cwu_18.Login_epe_07;
import com.sun.jdi.connect.spi.Connection;

public class LoginTest_mjo_56 {

	/*
	 * @author: Mansi Joshi
	 * Test Class to run test on Login feature
	 */
	
	Login_epe_07 login = new Login_epe_07();
	String testEmail;
	String testPass;
	JdbcTemplate jdbcTemplate;
	DAOImpl_cwu_18 dao;
	
	
	@BeforeEach
	void setUp(DataSource datasource)
	{
		testEmail = "cold8@skyrock.com";
		testPass = "keYvkKXCT";
		dao = new DAOImpl_cwu_18(datasource);
	}
	

	/*
	 * @author: Mansi Joshi
	 * Test credentials
	 */
	@Test
	public void testCredentials()
	{
		assertEquals(100596085, dao.getUserID(testEmail, testPass));	
	}
	
	/*
	 * @author: Mansi Joshi
	 * Test email
	 */
	@Test
	public void testEmail()
	{
		assertEquals(testEmail, login.getEmail());
	}
}
