package net.bozorgi.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import net.bozorgi.dao.Offers;
import net.bozorgi.service.OffersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OffersController {

	private OffersService offersService;

	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

	@RequestMapping("/offers")
	public String showOffers(Model model) {

		List<Offers> offers = offersService.getCurrent();
		model.addAttribute("offers", offers);
		return "offers";

	}

	@RequestMapping("/createoffer")
	public String createOffers(Model model, Principal principal) {

		Offers offer = null;

		if (principal != null) {
			String username = principal.getName();

			offer = offersService.getOffer(username);
			System.out.println("Username is not null and getOffer tries to get user previous offer.");
			System.out.println(username);
		}

		if (offer == null) {
			offer = new Offers();
			System.out.println("Username is not null, but offers is null!");
		}

		model.addAttribute("offers", offer);

		return "createoffer";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Offers offer, BindingResult result, Principal principal,
			@RequestParam(value = "delete", required = false) String delete) {

		if (result.hasErrors()) {
			return "createoffer";
		}

		if (delete == null) {
			System.out.println("doCreate method in OffersController");

			String username = principal.getName();
			offer.getUser().setUsername(username);

			offersService.saveOrUpdate(offer);

			return "offercreated";
		} else {
			offersService.delete(offer.getId());
			return "offerdeleted";
		}

	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String showTest(Model model, @RequestParam("id") String myId) {

		System.out.println("Id is: " + myId);
		return "test";

	}

}
