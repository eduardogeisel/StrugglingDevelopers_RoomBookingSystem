package com.csis3275.controller_cwu_18;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.dao_cwu_18.DAOImpl_cwu_18;
import com.csis3275.model_cwu_18.Booking_cwu_18;
import com.csis3275.model_cwu_18.Login_epe_07;

@Controller
public class Controller_cwu_18 {

	@Autowired
	DAOImpl_cwu_18 bookingDAOImpl;
	
	@ModelAttribute("booking")
	public Booking_cwu_18 setUpAddForm() {
		return new Booking_cwu_18();
	}
	
	@GetMapping("/showBookings")
	public String showBookings(HttpSession session, Model model) {
		List<Booking_cwu_18> bookings = bookingDAOImpl.getAllBookings();
		model.addAttribute("bookings", bookings);
		return "showBookings";
	}
	
	@ModelAttribute("login")
	public Login_epe_07 setUpAddForm1() {
		return new Login_epe_07();
	}
	
	@GetMapping("/login")
	public String login(HttpSession session, Model model) {
		List<Login_epe_07> logins = bookingDAOImpl.getEmailPassord();
		model.addAttribute("login", logins);
		return "login";
	}
}
