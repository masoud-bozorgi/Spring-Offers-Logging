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

	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	public void create(Offers offer) {
		offersDAO.createOffer(offer);
		System.out.println("create method in OffersService");

	}

	public boolean hasOffer(String name) {
		if (name == null) {
			return false;
		}

		List<Offers> offers = offersDAO.getOffers(name);

		if (offers.size() == 0) {
			return false;
		}

		return true;
	}

	public Offers getOffer(String username) {
		if (username == null) {
			System.out.println("In OffersService username is null!");
			return null;
		}

		List<Offers> offers = offersDAO.getOffers(username);

		if (offers.size() == 0) {
			System.out.println("In OffersService offers.size is 0!");
			return null;
		}
		
		System.out.println("offers.get(0) is going to run.");
		System.out.println(offers.get(0));
		return offers.get(0);
	}

	public void saveOrUpdate(Offers offer) {
		if (offer.getId() != 0) {
			offersDAO.updateOffer(offer);
			System.out.println("OffersService class: offer.getId() != 0, and offersDAO.updateOffer(offer) should run.");
		} else {
			System.out.println("OffersService class: offer.getId() == 0, and offersDAO.createOffer(offer) should run. ");
			offersDAO.createOffer(offer);
		}

	}

	public void delete(int id) {
		offersDAO.delete(id);
		
	}

}
