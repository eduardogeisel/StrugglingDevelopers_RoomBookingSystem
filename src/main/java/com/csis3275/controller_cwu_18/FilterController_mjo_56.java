package com.csis3275.controller_cwu_18;

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
import com.csis3275.model_cwu_18.Rooms_mjo_56;

@Controller
public class FilterController_mjo_56 {

	@Autowired
	DAOImpl_cwu_18 daoImpl;

	// Filter feature
	@ModelAttribute("rooms")
	public Rooms_mjo_56 setUpRoomForm() {
		return new Rooms_mjo_56();
	}

	// Show all the rooms
	@GetMapping("/showRooms")
	public String showRooms(@RequestParam(required = true) int id, Model model) {
		model.addAttribute("userId", id);
		List<Rooms_mjo_56> rooms = daoImpl.getAllRooms();
		model.addAttribute("rooms", rooms);
		return "showRooms_mjo_56";
	}

	@PostMapping("/filterRooms")
	public String filterRooms(@ModelAttribute("rooms") Rooms_mjo_56 filteredRoom, @RequestParam String equipment, @RequestParam int id,
			Model model) {
		model.addAttribute("userId", id);
		List<Rooms_mjo_56> rooms = daoImpl.getFilteredRooms(equipment);
		model.addAttribute("rooms", rooms);
		return "showRooms_mjo_56";
	}
}
