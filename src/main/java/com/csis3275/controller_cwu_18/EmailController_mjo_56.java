package com.csis3275.controller_cwu_18;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.dao_cwu_18.DAOImpl_cwu_18;
import com.csis3275.model_cwu_18.Email_mjo_56;

@Controller
public class EmailController_mjo_56 {

	@GetMapping("/inputEmail")
	public String inputEmail(HttpSession session, Model model) {
		return "inputEmail_mjo_56";
	}

	@GetMapping("/showEmail")
	public String showEmail(@RequestParam(required = true) String email, HttpSession session, Model model)
			throws AddressException, MessagingException {
		Email_mjo_56 em = new Email_mjo_56(email);
		em.sendEmail(email);
		return "successEmail_mjo_56";
	}
}
