package com.ensat.app.web.controller;

import static com.ensat.app.web.utils.ViewURIsMapping.USERS_ADMIN_LIST;
import static com.ensat.app.web.utils.ViewURIsMapping.USERS_ADMIN_NEW;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ensat.app.business.persistence.entities.Utilisateur;
import com.ensat.app.business.service.UtilisateurService;
import com.ensat.app.web.utils.ApplicationURIs;

@Controller
public class UtilisateurController {
	
	private static final Logger logger = LoggerFactory.getLogger(UtilisateurController.class);
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = ApplicationURIs.USERS_ADMIN_LIST, method = RequestMethod.GET)
	public String listUtilisateurs(
			Model model, 
			@RequestParam(defaultValue="1", value="page", required=false) Integer page,
			@RequestParam(defaultValue="5", value="pageSize", required=false) Integer pageSize) {
		int pageIndex = (page == null || page.intValue() <= 0) ? 0 : (page-1);
		if(pageSize == null || pageSize.intValue() <= 0) {
			pageSize = 5;
		}
		Page<Utilisateur> pageUsers = utilisateurService.pageUtilisateur(new PageRequest(pageIndex, pageSize));
		logger.info("##############################################");
		logger.info("Size of Page: {}.", pageUsers.getSize());
		logger.info("Size of Content List: {}.", pageUsers.getContent().size());
		logger.info("Total of Pages: {}.", pageUsers.getTotalPages());
		logger.info("Number : {}.", pageUsers.getNumber());
		logger.info("Number of elements : {}.", pageUsers.getNumberOfElements());
		logger.info("Total elements : {}.", pageUsers.getTotalElements());
		logger.info("##############################################");
		model.addAttribute("pageUsers", pageUsers);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentUrl", "/admin/utilisateurs/list/");
		model.addAttribute("userViewUrl", "/admin/utilisateurs/view/");
		model.addAttribute("userEditUrl", "/admin/utilisateurs/edit/");
		return USERS_ADMIN_LIST.getView();
	}
	
	@RequestMapping(value = ApplicationURIs.USERS_ADMIN_NEW, method = RequestMethod.GET)
	public String ajouterUtilisateurGet(){
		return USERS_ADMIN_NEW.getView();
	}
	
	@RequestMapping(value = ApplicationURIs.USERS_ADMIN_NEW, method = RequestMethod.POST)
	public String ajouterUtilisateurPost(Utilisateur utilisateur){
		
		return USERS_ADMIN_NEW.getView();
	}
	
}
