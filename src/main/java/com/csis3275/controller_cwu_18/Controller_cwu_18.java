package com.csis3275.controller_cwu_18;

import java.util.ArrayList;
import java.util.List;

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

@Controller
public class Controller_cwu_18 {

	@Autowired
	DAOImpl_cwu_18 DAOImpl;

	@ModelAttribute("booking")
	public Booking_cwu_18 setUpAddForm() {
		return new Booking_cwu_18();
	}

	@GetMapping("/showBookings")
	public String showBookings(HttpSession session, Model model) {
		List<Booking_cwu_18> bookings = DAOImpl.getAllBookings();
		model.addAttribute("bookings", bookings);
		return "showBookings";
	}

	// Filter feature
	@ModelAttribute("rooms")
	public Rooms_mjo_56 setUpRoomForm() {
		return new Rooms_mjo_56();
	}

	// Show all the rooms
	@GetMapping("/showRooms")
	public String showRooms(HttpSession session, Model model) {
		List<Rooms_mjo_56> rooms = DAOImpl.getAllRooms();
		model.addAttribute("rooms", rooms);
		return "showRooms";
	}

	@PostMapping("/filterRooms")
	public String filterRooms(@ModelAttribute("rooms") Rooms_mjo_56 filteredRoom, @RequestParam String equipment,
			Model model) {

		List<Rooms_mjo_56> rooms = DAOImpl.getFilteredRooms(equipment);
		model.addAttribute("rooms", rooms);
		return "showRooms";
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
		if (DAOImpl.getUser(login.getEmail(), login.getPassword()) == null) {
			model.addAttribute("message", "Login unsuccessful");
			return "login_epe_07";
		}
		model.addAttribute("successMessage", "Dear " + login.getEmail() + " , Welcome");
		model.addAttribute("login_epe_07", login);
		// creating session for user successful login
		session.setAttribute("user", login.getEmail());
		return "success_epe_07";
	}

	@GetMapping("/sessionEnd")
	public String sessionEnd(HttpSession session) {
		session.invalidate();
		// session.setAttribute("user", null);
		return "redirect:/login_epe_07";
	}
}
