package net.bozorgi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.log4j.Logger;

@Controller
public class HomeController {
	
	private static Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String showHome(){
		
		logger.info("Showing home page...");
		return"home";
		
	}

}
