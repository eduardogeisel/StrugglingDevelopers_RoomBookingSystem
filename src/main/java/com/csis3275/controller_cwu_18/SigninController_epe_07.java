package com.csis3275.controller_cwu_18;

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

import com.csis3275.dao_cwu_18.DAOImpl_cwu_18;
import com.csis3275.model_cwu_18.Login_epe_07;
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

		// creating session for user successful login

		session.setAttribute("email", login.getEmail());
		if (user.getUser_type() == 3) {
			return "successAdmin_epe_07";
		} else {
			return "success_epe_07";
		}

	}

	@GetMapping("/sessionEnd")
	public String sessionEnd(HttpSession session) {
		session.invalidate();
		// session.setAttribute("user", null);
		return "redirect:/login_epe_07";
	}
}
