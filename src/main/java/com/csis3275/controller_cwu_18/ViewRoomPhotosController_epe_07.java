package com.csis3275.controller_cwu_18;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.csis3275.model_cwu_18.ViewRoomPhotos_epe_07;



@Controller

@RequestMapping("/roomPhotos")

public class ViewRoomPhotosController_epe_07 {
	
	@RequestMapping(method = RequestMethod.GET)
	public String newProfile(ModelMap model) {
		ViewRoomPhotos_epe_07 roomPhotos = new ViewRoomPhotos_epe_07();
		
		model.addAttribute("roomPhotos", roomPhotos);
		
		return "viewRoomPhotos_epe_07";
	}

}
