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
public class Controller_cwu_18 {

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
		//int userId = 200774284;
		model.addAttribute("userId", id);
		// Add bookingId
		String bookingId = getRandomBookingID();
		model.addAttribute("bookingId", bookingId);
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
		
		if(dateList.contains(compareDate) && userList.contains(compareUser) && roomList.contains(compareRoom)) {
			String failureMessage = "Room is already booked: ";
			model.addAttribute("failureMessage", failureMessage);
			return "bookRoom_cwu_18";
		}
		else {
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
	
	
	//Confirm booking feature
	
	@GetMapping("/confirmBooking")
	public String confirmBooking(@RequestParam(required = true) int id, Model model) {
			
		Booking_cwu_18 confirmation = daoImpl.getBookingById(id);
		
		model.addAttribute("confirmation", confirmation);
		
		//return the new view
		return "bookingConfirmation_mjo_56";
	}
	
	@PostMapping("/confirmBooking")
	public String confirmBooking(@ModelAttribute("confirmation") Booking_cwu_18 confirmation, Model model) {

		daoImpl.createBooking(confirmation);
		model.addAttribute("confirmation", confirmation);

		return "bookingConfirmation_mjo_56";

	}


	
	//Delete data

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
	
	//Calendar Controller
	@GetMapping("/bookingCalendar")
	public String bookingCalendar(@RequestParam(required = true) int id, Model model) {

		List<Booking_cwu_18> bookings = daoImpl.getBookingsByUserId(id);
		model.addAttribute("bookings", bookings);
		
		int user_id = id;
		model.addAttribute("userId", user_id);
		
		
		model.addAttribute("num", "Repeating Event");
		return "bookingCalendar_cwu_18";
	}

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

	// Filter feature
	@ModelAttribute("rooms")
	public Rooms_mjo_56 setUpRoomForm() {
		return new Rooms_mjo_56();
	}




		// Show all the rooms
		@GetMapping("/showRooms")
		public String showRooms(HttpSession session, Model model) {
			List<Rooms_mjo_56> rooms = daoImpl.getAllRooms();
			model.addAttribute("rooms", rooms);
			return "showRooms_mjo_56";
		}


	@PostMapping("/filterRooms")
	public String filterRooms(@ModelAttribute("rooms") Rooms_mjo_56 filteredRoom, @RequestParam String equipment,
			Model model) {




			List<Rooms_mjo_56> rooms = daoImpl.getFilteredRooms(equipment);
			model.addAttribute("rooms", rooms);
			return "showRooms_mjo_56";
		}


	// Login feature
	@ModelAttribute("login_epe_07")
	public Login_epe_07 setUpAddForm1() {
		return new Login_epe_07();
	}

	@GetMapping("/login_epe_07")
	public String login(HttpSession session, Model model) {
		// Login_epe_07 login = bookingDAOImpl.getUser("etakisa@shutterfly.com",
		// "NBDhya6k");
		model.addAttribute("login_epe_07", new Login_epe_07());
		return "login_epe_07";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/success_epe_07")
	public String saveSession(HttpSession session, Login_epe_07 login, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "login_epe_07";
		}
		if (daoImpl.getUser(login.getEmail(), login.getPassword()) == null) {
			model.addAttribute("message", "Login unsuccessful");
			return "login_epe_07";
		}
		model.addAttribute("successMessage", "Dear " + login.getEmail() + " , Welcome");
		model.addAttribute("login_epe_07", login);

		User_sho_38 user = daoImpl.getUserByEmail(login.getEmail());
		// Add user model
		model.addAttribute("user", user);
		int userId = user.getUser_id();
		model.addAttribute("userId", userId);
		String user_name = daoImpl.getUserNameById(userId);
		model.addAttribute("userName", user_name);


		//creating session for user successful login

		session.setAttribute("email", login.getEmail());
		if(user.getUser_type() == 3) {
			return "successAdmin_epe_07";
		}
		else {
			return "success_epe_07";
		}
		
	}

	@GetMapping("/sessionEnd")
	public String sessionEnd(HttpSession session) {
		session.invalidate();
		// session.setAttribute("user", null);
		return "redirect:/login_epe_07";
	}

	// Random Number Generator
	public static String getRandomBookingID() {
		// It will generate 6 digit random Number.
		// from 0 to 999999
		Random rnd = new Random();
		int number = rnd.nextInt(999999);

		// this will convert any number sequence into 6 character.
		return String.format("%06d", number);
	}

	// Sign up feature
	@ModelAttribute("user_sho_38")
	public User_sho_38 setUpSignupForm() {
		return new User_sho_38();
	}

	@GetMapping("/register_sho_38")
	public String showRegister(HttpSession session, Model model) {

		return "register_sho_38";
	}

	@PostMapping("/register_sho_38")
	public String addNewUser(HttpSession session, User_sho_38 newUser, Model model) {
		List<String> emailList = daoImpl.getAllEmails();
		String compareEmail = newUser.getEmail();
		if (emailList.contains(compareEmail)) {
			String failureMessage = "Already has the email address: " + compareEmail;
			model.addAttribute("failureMessage", failureMessage);

		} else {
			String successMessage = "Successfully Sign Up";
			model.addAttribute("successMessage", successMessage);
			newUser.setUser_id(generateUserId(newUser));
			daoImpl.register(newUser);
		}

		return "login_epe_07";

	}

	public int generateUserId(User_sho_38 user) {

		int userId = 0;
		if (user.getUser_type() == 1) {
			userId = 100000000 + Integer.parseInt(getRandomBookingID());

		} else if (user.getUser_type() == 2) {
			userId = 200000000 + Integer.parseInt(getRandomBookingID());

		}
		return userId;

	}
	
	
	/**
	 * 
	 * @author Eduardo Geisel Peres - 300318007
	 * This is the get mapping for the booking limitation admin feature.
	 * The booking limitation is a feature where an admin can remove the booking of a specific room on a specific day
	 * for a specific purpose (maintenance, cleaning, fumigation...). Basically the admin logs in to the web app and
	 * goes to the booking limitation view, there he inputs a title (one of the purposes for this limitation), a short
	 * description, the room that will be limited for booking and the date. After he inputs all of that information, 
	 * the admin submits the form and then he will go to a booking limitation confirmation page, where he can delete that 
	 * limitation if he desires.
	 * 
	 */
	
	//Booking Limitation (admin Feature)
	@GetMapping("/bookingLimitation")
	public String bookingLimitation(@RequestParam(required = true) int id, Model model) {
		
		
		List<Booking_cwu_18> limitations = daoImpl.getBookingsByUserId(123456789);
		
		
		model.addAttribute("userId", id);		
		String bookingId = getRandomBookingID();
		model.addAttribute("bookingId", bookingId);
		return "bookingLimitation_epe_07";
	}
	
	
}
