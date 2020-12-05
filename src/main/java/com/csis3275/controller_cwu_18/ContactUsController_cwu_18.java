package com.csis3275.controller_cwu_18;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.dao_cwu_18.DAOImpl_cwu_18;
import com.csis3275.model_cwu_18.Comment_cwu_18;

@Controller
public class ContactUsController_cwu_18 {

	@Autowired
	DAOImpl_cwu_18 daoImpl;

	// Add Contact Us Feature
	@ModelAttribute("contact")
	public Comment_cwu_18 setUpAddForm() {
		return new Comment_cwu_18();
	}

	@GetMapping("/contactus")
	public String writeComments(@RequestParam(required = true) int id, Model model) {
		model.addAttribute("userId", id);
		return "ContactUs_cwu_18";
	}

	// admin
	@GetMapping("/viewcomments")
	public String viewComments(@RequestParam(required = true) int id, Model model) {
		model.addAttribute("userId", id);
		List<Comment_cwu_18> comments =	daoImpl.getAllComments();
		model.addAttribute("comments", comments);

		return "ViewComments_cwu_18";
	}

	@ModelAttribute("countries")
	public List<String> setUpCountryList() {
		List<String> countries = new ArrayList<String>();
		countries.add("Canada");
		countries.add("USA");
		countries.add("Brazil");
		countries.add("India");

		return countries;
	}

}
