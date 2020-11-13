/*
 * @Mansi Joshi (Student Id: 300317856) - Feature: Filter Rooms - Iteration 1
 * 
 * This feature allows the user to browse through options based on equipment availability.
 * The user can choose this option using navigation link after successfully logging in to
 * the system. On choosing this option, the default list will show all rooms in the system
 * along with a list of equipments available in each room.
 * This list is fetched from the database with the help of the dao.
 * Next, the user can choose the equipment they need from the dropdown list on the page.
 * On choosing the equipment, the user will be able to view a list of rooms that contain
 * the selected equipment. The user has an option to navigate to other pages and come back
 * to the Filter Rooms page by using the navigation bar.
 */

package com.csis3275.model_cwu_18;

import org.springframework.format.annotation.DateTimeFormat;

public class Rooms_mjo_56 {

	private String room_id;
	private String room_type;
	private int capacity;
	private String equipment;
	
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}	

}
