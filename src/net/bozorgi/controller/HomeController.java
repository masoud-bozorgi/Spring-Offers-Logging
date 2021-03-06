package net.bozorgi.controller;

import java.security.Principal;
import java.util.List;

import net.bozorgi.dao.Offers;
import net.bozorgi.service.OffersService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private static Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	private OffersService offersService;

	@RequestMapping("/")
	public String showHome(Model model, Principal principal) {

		List<Offers> offers = offersService.getCurrent();
		model.addAttribute("offers", offers);

		boolean hasOffer = false;

		if (principal != null) {
			hasOffer = offersService.hasOffer(principal.getName());
		}

		model.addAttribute("hasOffer", hasOffer);
		
		System.out.println("HomeController is run and home is returned");
		return "home";

	}

}
