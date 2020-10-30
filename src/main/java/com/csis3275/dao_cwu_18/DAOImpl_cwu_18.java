package com.csis3275.dao_cwu_18;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.csis3275.model_cwu_18.BookingMapper_cwu_18;
import com.csis3275.model_cwu_18.Booking_cwu_18;
import com.csis3275.model_cwu_18.LoginMapper_epe_07;
import com.csis3275.model_cwu_18.Login_epe_07;
import com.csis3275.model_cwu_18.RoomsMapper_mjo_56;
import com.csis3275.model_cwu_18.Rooms_mjo_56;

@Component
public class DAOImpl_cwu_18 {

	JdbcTemplate jdbcTemplate;
	

	//manage Booking feature
	private final String SQL_INSERT_BOOKING = "INSERT INTO BOOKINGS (booking_id, dateTime, startTime, endTime, title, description, user_id, room_id) VALUES(?,?,?,?,?,?,?,?)";
	private final String SQL_FIND_BOOKING_BY_USERID = "SELECT * FROM BOOKINGS WHERE USER_ID = ?";
	private final String SQL_FIND_BOOKING_BY_BOOKINGID = "SELECT * FROM BOOKINGS WHERE BOOKING_ID = ?";
	private final String SQL_GET_USERNAME_BY_ID = "SELECT FIRST_NAME FROM USERS WHERE USER_ID = ?";
	private final String SQL_GET_USERID_BY_EMAIL = "SELECT USER_ID FROM USERS WHERE EMAIL = ?";
	private final String SQL_UPDATE_BOOKING = "UPDATE BOOKINGS set booking_id =?, dateTime = ?, startTime = ?, endTime = ?, title = ?, description = ?, user_id = ?, room_id = ? WHERE user_id = ?";
	private final String SQL_DELETE_BOOKING = "DELETE FROM BOOKINGS WHERE BOOKING_ID = ?";
	//login feature

	//Bookings
	private final String SQL_GET_ALL = "SELECT * FROM BOOKINGS";

	// Filter feature
	private final String SQL_GET_ROOMS = "SELECT * FROM ROOMS";
	private final String SQL_FILTER_ROOMS = "SELECT ROOM_ID, ROOM_TYPE, CAPACITY, EQUIPMENT FROM ROOMS WHERE EQUIPMENT ~* ? ";
	// login feature
	private final String SQL_GET_EMAIL_PASS = "SELECT EMAIL, PASSWORD FROM USERS";
	private final String SQL_FIND_USER = "SELECT * FROM USERS WHERE email = ? AND password = ?";

	@Autowired
	public DAOImpl_cwu_18(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Booking_cwu_18> getAllBookings() {
		return jdbcTemplate.query(SQL_GET_ALL, new BookingMapper_cwu_18());
	}
	
	//insert new booking into database
	public boolean createBooking(Booking_cwu_18 newBooking) {
		return jdbcTemplate.update(SQL_INSERT_BOOKING, newBooking.getBooking_id(),newBooking.getDateTime(),
				newBooking.getStartTime(), newBooking.getEndTime(), newBooking.getTitle(), 
				newBooking.getDescription(), newBooking.getUser_id(), newBooking.getRoom_id()) > 0;
	}
	
	public List<Booking_cwu_18> getBookingsByUserId(int user_id){
		return jdbcTemplate.query(SQL_FIND_BOOKING_BY_USERID, new Object[] {user_id},new BookingMapper_cwu_18());
	}
	public String getUserIdByEmail(String email){
		return jdbcTemplate.queryForObject(SQL_GET_USERID_BY_EMAIL, new Object[] {email}, String.class);
	}
	
	public String getUserNameById(int user_id) {
		return jdbcTemplate.queryForObject(SQL_GET_USERNAME_BY_ID, new Object[] { user_id }, String.class);
	}
	public boolean updateBooking(Booking_cwu_18 newBooking) {
		return jdbcTemplate.update(SQL_UPDATE_BOOKING, newBooking.getBooking_id(), 
				newBooking.getDateTime(), newBooking.getStartTime(), newBooking.getEndTime(),
				newBooking.getTitle(), newBooking.getDescription(), newBooking.getUser_id(), 
				newBooking.getRoom_id(), newBooking.getUser_id()) > 0;
	}
	
	public Booking_cwu_18 getBookingById(int booking_id) {
		return jdbcTemplate.queryForObject(SQL_FIND_BOOKING_BY_BOOKINGID, new Object[] {booking_id}, new BookingMapper_cwu_18());
	}
	
	public boolean deleteBooking(int idToDelete) {
		return jdbcTemplate.update(SQL_DELETE_BOOKING, idToDelete)>0;
	}
	
	
	// Login activity
		public List<Login_epe_07> getEmailPassord() {
			return jdbcTemplate.query(SQL_GET_EMAIL_PASS, new LoginMapper_epe_07());
		}

		public Login_epe_07 getUser(String email, String password) {
			// return jdbcTemplate.queryForObject(SQL_FIND_USER, new Object[] { email,
			// password }, new LoginMapper_epe_07());

			List<Login_epe_07> strLst = jdbcTemplate.query(SQL_FIND_USER, new LoginMapper_epe_07(), email, password);

			if (strLst.isEmpty()) {
				return null;
			} else if (strLst.size() == 1) {
				return strLst.get(0);
			} else {
				return null;
			}
		}

	// Filter feature
	public List<Rooms_mjo_56> getAllRooms() {
		return jdbcTemplate.query(SQL_GET_ROOMS, new RoomsMapper_mjo_56());
	}

	public List<Rooms_mjo_56> getFilteredRooms(String equipment) {
		return jdbcTemplate.query(SQL_FILTER_ROOMS, new Object[] { equipment }, new RoomsMapper_mjo_56());
	}

	

	
}
