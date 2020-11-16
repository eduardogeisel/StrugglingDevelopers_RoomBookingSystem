package com.csis3275.controller_cwu_18;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.dao_cwu_18.DAOImpl_cwu_18;
import com.csis3275.model_cwu_18.Booking_cwu_18;
import com.csis3275.model_cwu_18.Login_epe_07;
import com.csis3275.model_cwu_18.Rooms_mjo_56;

import com.csis3275.model_cwu_18.User_sho_38;

@Controller
public class BookingController_cwu_18 {

	@Autowired
	DAOImpl_cwu_18 daoImpl;

	// Add Booking Feature
	@ModelAttribute("booking")
	public Booking_cwu_18 setUpAddForm() {
		return new Booking_cwu_18();
	}

	@GetMapping("/bookRoom")
	public String bookRoom(@RequestParam(required = true) int id, Model model) {
		// Add userId
		// int userId = 200774284;
		model.addAttribute("userId", id);
		// Add bookingId
		//String bookingId = IdGenerator_cwu_18.getRandomBookingID();
		//model.addAttribute("bookingId", bookingId);
		return "bookRoom_cwu_18";
	}

	@GetMapping("/showBookings")
	public String showBookings(@RequestParam(required = true) int id, Model model) {
		List<Booking_cwu_18> bookings = daoImpl.getBookingsByUserId(id);
		model.addAttribute("bookings", bookings);

		String user_name = daoImpl.getUserNameById(id);
		model.addAttribute("userName", user_name);

		int user_id = id;
		model.addAttribute("userId", user_id);
		return "showBookings_cwu_18";
	}

	@PostMapping("/showBookings")
	public String insertBooking(@ModelAttribute("booking") Booking_cwu_18 newBooking, Model model) {

		List<Rooms_mjo_56> roomList = daoImpl.getAllRooms();
		List<User_sho_38> userList = daoImpl.getAllUsers();
		List<Booking_cwu_18> dateList = daoImpl.getAllBookings();

		Date compareDate = newBooking.getDateTime();
		int compareUser = newBooking.getUser_id();
		String compareRoom = newBooking.getRoom_id();

		if (dateList.contains(compareDate) && userList.contains(compareUser) && roomList.contains(compareRoom)) {
			String failureMessage = "Room is already booked: ";
			model.addAttribute("failureMessage", failureMessage);
			return "bookRoom_cwu_18";
		} else {
			daoImpl.createBooking(newBooking);
			int userId = newBooking.getUser_id();
			List<Booking_cwu_18> bookings = daoImpl.getBookingsByUserId(userId);
			String user_name = daoImpl.getUserNameById(userId);
			model.addAttribute("bookings", bookings);
			model.addAttribute("userName", user_name);

			User_sho_38 user = daoImpl.getUserById(userId);
			model.addAttribute("user", user);
			return "showBookings_cwu_18";
		}

	}

	// Confirm booking feature mappings

	@GetMapping("/confirmBooking")
	public String confirmBooking(@RequestParam(required = true) int id, Model model) {

		Booking_cwu_18 confirmation = daoImpl.getBookingById(id);

		model.addAttribute("confirmation", confirmation);

		// return the new view
		return "bookingConfirmation_mjo_56";
	}

	@PostMapping("/confirmBooking")
	public String confirmBooking(@ModelAttribute("confirmation") Booking_cwu_18 confirmation, Model model) {

		daoImpl.createBooking(confirmation);
		model.addAttribute("confirmation", confirmation);

		return "bookingConfirmation_mjo_56";

	}

	// Delete data

	@GetMapping("/deleteBooking")
	public String deleteBooking(@RequestParam(required = true) int id, Model model) {

		Booking_cwu_18 deletedBooking = daoImpl.getBookingById(id);
		daoImpl.deleteBooking(id);
		int deletedUserId = deletedBooking.getUser_id();
		List<Booking_cwu_18> bookings = daoImpl.getBookingsByUserId(deletedUserId);
		model.addAttribute("bookings", bookings);
		model.addAttribute("deleteMessage", "Deleted Booking: " + id);

		return "showBookings_cwu_18";
	}

	// Edit data
	@GetMapping("/editBooking")
	public String editBooking(@RequestParam(required = true) int id, Model model) {

		Booking_cwu_18 updatedBooking = daoImpl.getBookingById(id);
		model.addAttribute("booking", updatedBooking);

		return "editBooking_cwu_18";
	}

	@PostMapping("/editBooking")
	public String updateBooking(@ModelAttribute("booking") Booking_cwu_18 updatedBooking, Model model) {

		daoImpl.updateBooking(updatedBooking);
		int userId = updatedBooking.getUser_id();
		List<Booking_cwu_18> bookings = daoImpl.getBookingsByUserId(userId);
		model.addAttribute("bookings", bookings);

		model.addAttribute("message", "Edited Booking " + updatedBooking.getBooking_id());

		return "showBookings_cwu_18";

	}

	/**
	 * 
	 * @author Eduardo Geisel Peres - 300318007 This is the get mapping for the
	 *         booking limitation admin feature. The booking limitation is a feature
	 *         where an admin can remove the booking of a specific room on a
	 *         specific day for a specific purpose (maintenance, cleaning,
	 *         fumigation...). Basically the admin logs in to the web app and goes
	 *         to the booking limitation view, there he inputs a title (one of the
	 *         purposes for this limitation), a short description, the room that
	 *         will be limited for booking and the date. After he inputs all of that
	 *         information, the admin submits the form and then he will go to a
	 *         booking limitation confirmation page, where he can delete that
	 *         limitation if he desires.
	 * 
	 */

	// Booking Limitation (admin Feature)
	@GetMapping("/bookingLimitation")
	public String bookingLimitation(@RequestParam(required = true) int id, Model model) {

		List<Booking_cwu_18> limitations = daoImpl.getBookingsByUserId(123456789);

		model.addAttribute("userId", id);
		//String bookingId = IdGenerator_cwu_18.getRandomBookingID();
		//model.addAttribute("bookingId", bookingId);
		return "bookingLimitation_epe_07";
	}

	/*
	 * Extra Models
	 */
	@ModelAttribute("title")
	public List<String> initialzeTitle() {
		List<String> title = new ArrayList<String>();
		title.add("Group Study");
		title.add("Meeting");
		title.add("Seminar");
		title.add("Workshop");
		title.add("Activity");
		return title;
	}

	@ModelAttribute("roomOptions")
	public List<String> initialzeRooms() {
		List<String> rooms = new ArrayList<String>();
		List<Rooms_mjo_56> roomObject = daoImpl.getAllRooms();

		return rooms;
	}

}
