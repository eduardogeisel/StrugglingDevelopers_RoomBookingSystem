package com.csis3275.controller_cwu_18;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.model_cwu_18.Contact_cwu_18;

@Controller
public class ContactUsController_cwu_18 {
	
		
		// Add Contact Us Feature
		@ModelAttribute("contact")
		public Contact_cwu_18 setUpAddForm() {
			return new Contact_cwu_18();
		}
		
		@GetMapping("/contactus")
		public String bookRoom(@RequestParam(required = true) int id, Model model) {
			
			return "ContactUs_cwu_18";
		}
}
