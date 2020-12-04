package com.csis3275.controller_cwu_18;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class ViewRoomPhotosController_epe_07 {
	
	 @RequestMapping(value="/",method = RequestMethod.GET)
	    public ModelAndView index() {
	        ModelAndView mv=new ModelAndView("welcome");
	       return mv;

}
