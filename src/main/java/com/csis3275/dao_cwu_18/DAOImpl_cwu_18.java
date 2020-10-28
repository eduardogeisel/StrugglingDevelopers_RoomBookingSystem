package com.csis3275.dao_cwu_18;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.csis3275.model_cwu_18.BookingMapper_cwu_18;
import com.csis3275.model_cwu_18.Booking_cwu_18;


@Component
public class DAOImpl_cwu_18 {
	
	JdbcTemplate jdbcTemplate;
	private final String SQL_GET_ALL = "SELECT * FROM BOOKINGS";
	
	@Autowired
	public DAOImpl_cwu_18(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Booking_cwu_18> getAllBookings(){
		return jdbcTemplate.query(SQL_GET_ALL,new BookingMapper_cwu_18());
	}
}
