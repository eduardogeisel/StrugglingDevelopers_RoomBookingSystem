package com.csis3275.model_cwu_18;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookingMapper_cwu_18 implements RowMapper<Booking_cwu_18>{

	
	public Booking_cwu_18 mapRow(ResultSet rs, int rowNum) throws SQLException {
		Booking_cwu_18 booking = new Booking_cwu_18();
		booking.setBooking_id(rs.getInt("booking_id"));
		booking.setDateTime(rs.getDate("dateTime"));
		booking.setStartTime(rs.getTime("startTime"));
		booking.setEndTime(rs.getTime("endTime"));
		booking.setTitle(rs.getString("title"));
		booking.setDescription(rs.getString("description"));
		booking.setUser_id(rs.getInt("user_id"));
		booking.setRoom_id(rs.getString("room_id"));
		return booking;
	}
	

}
