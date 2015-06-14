package net.bozorgi.service;

import java.util.List;

import net.bozorgi.dao.Offers;
import net.bozorgi.dao.OffersDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service("offersService")
public class OffersService {

	private OffersDAO offersDAO;

	@Autowired
	public void setOfferDAO(OffersDAO offerDAO) {
		this.offersDAO = offerDAO;
	}

	public List<Offers> getCurrent() {
		return offersDAO.getOffers();
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public void create(Offers offer) {
		offersDAO.createOffer(offer);
		System.out.println("create method in OffersService");
		
	}

}
