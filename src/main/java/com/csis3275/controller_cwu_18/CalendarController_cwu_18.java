package com.csis3275.controller_cwu_18;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.dao_cwu_18.DAOImpl_cwu_18;
import com.csis3275.model_cwu_18.Booking_cwu_18;

@Controller
public class CalendarController_cwu_18 {
	@Autowired
	DAOImpl_cwu_18 daoImpl;

	// Calendar Controller
	@GetMapping("/bookingCalendar")
	public String bookingCalendar(@RequestParam(required = true) int id, Model model) {

		List<Booking_cwu_18> bookings = daoImpl.getBookingsByUserId(id);
		model.addAttribute("bookings", bookings);

		int user_id = id;
		model.addAttribute("userId", user_id);

		model.addAttribute("num", "Repeating Event");
		return "bookingCalendar_cwu_18";
	}
}
