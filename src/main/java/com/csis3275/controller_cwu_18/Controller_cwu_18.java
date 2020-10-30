package com.csis3275.controller_cwu_18;

import java.sql.Time;
import java.util.ArrayList;
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


@Controller
public class Controller_cwu_18 {

	@Autowired
	DAOImpl_cwu_18 daoImpl;
	
	
	//Add Booking Feature
	@ModelAttribute("booking")
	public Booking_cwu_18 setUpAddForm() {
		return new Booking_cwu_18();
	}
	
	/*@GetMapping("/showBookings")
	public String showBookings(HttpSession session, Model model) {
		List<Booking_cwu_18> bookings = daoImpl.getAllBookings();
		model.addAttribute("bookings", bookings);
		return "showBookings";
	}*/
	
	@GetMapping("/bookRoom")
	public String bookRoom(HttpSession session, Model model) {
		//Add userId
		String userId = "100029323";
		model.addAttribute("user_id", userId);
		//Add bookingId
		String bookingId = getRandomBookingID();
		model.addAttribute("bookingId", bookingId);
		return "bookRoom_cwu_18";
	}
	@PostMapping("bookRoom")
	public String insertBooking(@RequestParam(required = true) int user_id,@ModelAttribute("booking") Booking_cwu_18 newBooking, Model model) {
		daoImpl.createBooking(newBooking);
		List<Booking_cwu_18> bookings = daoImpl.getBookingsByUserId(user_id);
		String user_name = daoImpl.getUserNameById(user_id);
		model.addAttribute("bookings", bookings);
		model.addAttribute("userName", user_name);
		return "showBookings";
		
	} 
	/*
	//Edit data
		@GetMapping("/editBooking")
		public String editBooking(@RequestParam(required = true) int id, Model model)	{
					
			//Get the student
			Booking_cwu_18 updatedBooking = daoImpl.getBookingById(id);
			model.addAttribute("booking", updatedBooking);
			
			return "editBooking";
		}
		
		@PostMapping("/editBooking")
		public String updateBooking(@ModelAttribute("booking") Booking_cwu_18 updatedBooking, Model model)	{
			
			daoImpl.updateBooking(updatedBooking);
			
			//Get a list of students from the controller
			List<Booking_cwu_18> bookings = daoImpl.getAllBookings();
			model.addAttribute("bookings", bookings);
		
			model.addAttribute("message","Edited Booking " + updatedBooking.getId());
			
			//We are redirecting to show students so that the GETMapping is executed again because our edit did not add the list of students to the model
			return "showBookings";
			
		}
		*/
	
	@GetMapping("/showBookings")
	public String showBookings(@RequestParam(required = true) int user_id, Model model) {
		List<Booking_cwu_18> bookings = daoImpl.getBookingsByUserId(user_id);
		model.addAttribute("bookings", bookings);
		return "showBookings";
	}
	
	@ModelAttribute("title")
	public List<String> initialzeTitle(){
		List<String> title = new ArrayList<String>();
		title.add("Group Study");
		title.add("Meeting");
		title.add("Seminar");
		title.add("Workshop");
		title.add("Activity");
		return title;
	}
		
	//Login feature
	@ModelAttribute("login_epe_07")
	public Login_epe_07 setUpAddForm1() {
		return new Login_epe_07();
	}
	
	@GetMapping("/login_epe_07")
	public String login(HttpSession session, Model model) {
		//Login_epe_07 login = bookingDAOImpl.getUser("etakisa@shutterfly.com", "NBDhya6k");
		model.addAttribute("login_epe_07", new Login_epe_07());
		return "login_epe_07";
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/success_epe_07")
	public String saveSession(HttpSession session, Login_epe_07 login, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "login_epe_07";
		}
		if(daoImpl.getUser(login.getEmail(), login.getPassword()) == null) {
			model.addAttribute("message", "Login unsuccessful");
			return "login_epe_07";
		}
		model.addAttribute("successMessage", "Dear " + login.getEmail() + " , Welcome");
		model.addAttribute("login_epe_07", login);
		String user_id = daoImpl.getUserIdByEmail(login.getEmail());
		model.addAttribute("user_id", user_id);
		//creating session for user successful login
		session.setAttribute("user", login.getEmail());
		return "success_epe_07";
	}
	
	@GetMapping("/sessionEnd")
	public String sessionEnd(HttpSession session) {
		session.invalidate();
		//session.setAttribute("user", null);
		return "redirect:/login_epe_07";
	}
	
	//Random Number Generator
	public static String getRandomBookingID() {
	    // It will generate 6 digit random Number.
	    // from 0 to 999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 6 character.
	    return String.format("%06d", number);
	}
}
