package com.csis3275.controller_cwu_18;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.csis3275.model_cwu_18.User_cwu_18;

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
	public String bookRoom(HttpSession session, Model model) {
		// Add userId
		int userId = 200774284;
		model.addAttribute("userId", userId);
		// Add bookingId
		String bookingId = getRandomBookingID();
		model.addAttribute("bookingId", bookingId);
		return "bookRoom_cwu_18";
	}

	@GetMapping("/showBookings")
	public String showBookings(@RequestParam(required = true) int user_id, Model model) {
		List<Booking_cwu_18> bookings = daoImpl.getBookingsByUserId(user_id);
		model.addAttribute("bookings", bookings);
		return "showBookings_cwu_18";
	}

	@PostMapping("/showBookings")
	public String insertBooking(@ModelAttribute("booking") Booking_cwu_18 newBooking, Model model) {
		daoImpl.createBooking(newBooking);
		int userId = newBooking.getUser_id();
		List<Booking_cwu_18> bookings = daoImpl.getBookingsByUserId(userId);
		String user_name = daoImpl.getUserNameById(userId);
		model.addAttribute("bookings", bookings);
		model.addAttribute("userName", user_name);

		User_cwu_18 user = daoImpl.getUserById(userId);
		model.addAttribute("user", user);

		return "showBookings_cwu_18";

	}



	
	//Delete data

	@GetMapping("/deleteBooking")
	public String deleteBookings(@RequestParam(required = true) int booking_id, Model model) {
		daoImpl.deleteBooking(booking_id);
		List<Booking_cwu_18> bookings = daoImpl.getAllBookings();
		model.addAttribute("bookings", bookings);
		return "showBookings";
	}

	// Edit data
	@GetMapping("/editBooking")
	public String editBooking(@RequestParam(required = true) int booking_id, Model model) {

		Booking_cwu_18 updatedBooking = daoImpl.getBookingById(booking_id);
		model.addAttribute("booking", updatedBooking);

		return "editBooking_cwu_18";
	}

	@PostMapping("/editBooking")
	public String updateBooking(@ModelAttribute("booking") Booking_cwu_18 updatedBooking, Model model) {

		daoImpl.updateBooking(updatedBooking);
		List<Booking_cwu_18> bookings = daoImpl.getAllBookings();
		model.addAttribute("bookings", bookings);

		model.addAttribute("message", "Edited Booking " + updatedBooking.getBooking_id());

		return "showBookings";

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

	@ModelAttribute("rooms")
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

		User_cwu_18 user = daoImpl.getUserByEmail(login.getEmail());
		// Add user model
		model.addAttribute("user", user);
		int userId = user.getUser_id();
		model.addAttribute("userId", userId);
		String user_name = daoImpl.getUserNameById(userId);
		model.addAttribute("userName", user_name);


		//creating session for user successful login

		session.setAttribute("email", login.getEmail());
		return "success_epe_07";
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
}
