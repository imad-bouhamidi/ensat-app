package com.ensat.app.web.controller;

import static com.ensat.app.web.utils.ViewURIsMapping.HOME;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ensat.app.business.persistence.entities.Utilisateur;
import com.ensat.app.business.persistence.repositories.UtilisateurRepository;
import com.ensat.app.web.utils.ApplicationURIs;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("userDto")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = ApplicationURIs.HOME, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Utilisateur user1 = utilisateurRepository.findOne(1L);
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("userDto", user1);
		
		return HOME.getView();
	}
	
}
