package com.ensat.app.web.controller;

import static com.ensat.app.web.utils.ViewURIsMapping.LOGIN;
import static com.ensat.app.web.utils.ViewURIsMapping.LOGIN_ERROR;
import static com.ensat.app.web.utils.ViewURIsMapping.NOT_FOUND;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensat.app.web.utils.ApplicationURIs;


@Controller
public class GlobalController {
	
	@RequestMapping(value = ApplicationURIs.LOGIN, method = RequestMethod.GET)
	public String login() {
		return LOGIN.getView();
	}
	
	@RequestMapping(value = ApplicationURIs.LOGIN_ERROR, method = RequestMethod.GET)
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return LOGIN_ERROR.getView();
    }
	
	@RequestMapping(ApplicationURIs.LOGOUT)
	public String logout() {
		return "redirect:/j_spring_security_logout";
	}
	
	@RequestMapping(value = ApplicationURIs.NOT_FOUND, method = RequestMethod.GET)
	public String notFound() {
		return NOT_FOUND.getView();
	}

}
