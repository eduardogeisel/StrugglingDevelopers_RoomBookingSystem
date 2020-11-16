package com.csis3275.controller_cwu_18;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.csis3275.dao_cwu_18.DAOImpl_cwu_18;
import com.csis3275.model_cwu_18.User_sho_38;

@Controller
public class SigninController_epe_07 {
	@Autowired
	DAOImpl_cwu_18 daoImpl;
	
	/*
	 * Sign up feature
	 */
	
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
				newUser.setUser_id(IdGenerator_cwu_18.generateUserId(newUser));
				daoImpl.register(newUser);
			}

			return "login_epe_07";

		}
}
