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
	private final String SQL_GET_ALL = "SELECT * FROM BOOKINGS";

	// Filter feature
	private final String SQL_GET_ROOMS = "SELECT * FROM ROOMS";
	private final String SQL_FILTER_ROOMS = "SELECT ROOM_ID, ROOM_TYPE, CAPACITY, EQUIPMENT FROM ROOMS WHERE EQUIPMENT LIKE '%?%' OR EQUIPMENT LIKE '%?' OR EQUIPMENT LIKE '?%' OR EQUIPMENT LIKE '?' ";

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

	// Filter feature
	public List<Rooms_mjo_56> getAllRooms() {
		return jdbcTemplate.query(SQL_GET_ROOMS, new RoomsMapper_mjo_56());
	}

	public List<Rooms_mjo_56> getFilteredRooms(String equipment) {
		return jdbcTemplate.query(SQL_FILTER_ROOMS, new Object[] { equipment }, new RoomsMapper_mjo_56());
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
}
