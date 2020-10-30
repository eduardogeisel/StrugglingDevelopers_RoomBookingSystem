package com.csis3275.model_cwu_18;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RoomsMapper_mjo_56 implements RowMapper<Rooms_mjo_56>{

	
	public Rooms_mjo_56 mapRow(ResultSet rs, int rowNum) throws SQLException {
		Rooms_mjo_56 rooms = new Rooms_mjo_56();
		
		rooms.setRoom_id(rs.getString("room_id"));
		rooms.setRoom_type(rs.getString("room_type"));
		rooms.setCapacity(rs.getInt("capacity"));
		rooms.setEquipment(rs.getString("equipment"));
		return rooms;
	}
	

}
