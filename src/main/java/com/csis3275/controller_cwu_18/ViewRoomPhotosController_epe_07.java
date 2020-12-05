package com.csis3275.controller_cwu_18;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.csis3275.dao_cwu_18.DAOImpl_cwu_18;
import com.csis3275.model_cwu_18.Booking_cwu_18;
import com.csis3275.model_cwu_18.User_sho_38;
import com.csis3275.model_cwu_18.ViewRoomPhotos_epe_07;



@Controller
public class ViewRoomPhotosController_epe_07 {
	
	
//	@RequestMapping(method = RequestMethod.GET)
//	public String newProfile(ModelMap model) {
//		ViewRoomPhotos_epe_07 roomPhotos = new ViewRoomPhotos_epe_07();
//		User_sho_38 user = new User_sho_38();
//		int userId = user.getUser_id();
//		
//		model.addAttribute("roomPhotos", roomPhotos);
//		model.addAttribute("userId", userId);
//		
//		return "viewRoomPhotos_epe_07";
//	}
	@GetMapping("/roomPhotos")
	public String newProfile(@RequestParam(required = true) int id, Model model) {
		ViewRoomPhotos_epe_07 roomPhotos = new ViewRoomPhotos_epe_07();
		//User_sho_38 user = new User_sho_38();
		int userId = id;
		
		model.addAttribute("roomPhotos", roomPhotos);
		model.addAttribute("userId", userId);
		
		return "viewRoomPhotos_epe_07";
	}

}
