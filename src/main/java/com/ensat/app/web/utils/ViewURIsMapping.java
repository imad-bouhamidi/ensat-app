package com.ensat.app.web.utils;


/**
 * @author BOUHAMIDI
 * correspondance entre l'URI qui s'ecrit dans l'adresse du navigateur et le nom du la view tiles
 * 
 */
public enum ViewURIsMapping {

	NOT_FOUND(ApplicationURIs.NOT_FOUND, "404"),
	HOME(ApplicationURIs.HOME, "fragments/home"),
	LOGIN(ApplicationURIs.LOGIN, "login"),
	LOGIN_ERROR(ApplicationURIs.LOGIN_ERROR, "login"),
	USERS_ADMIN_LIST(ApplicationURIs.USERS_ADMIN_LIST, "admin/utilisateurs/list"),
	USERS_ADMIN_NEW(ApplicationURIs.USERS_ADMIN_NEW, "admin/utilisateurs/new"),
	USERS_ADMIN_VIEW(ApplicationURIs.USERS_ADMIN_VIEW, "admin/utilisateurs/view"),
	USERS_ADMIN_EDIT(ApplicationURIs.USERS_ADMIN_EDIT, "admin/utilisateurs/edit"),
	USERS_ADMIN_DELETE(ApplicationURIs.USERS_ADMIN_DELETE, "admin/utilisateurs/delete"),
	;
	
	private String uri;
	private String view;
	
	
	ViewURIsMapping(String uri, String view) {
		this.uri = uri;
		this.view = view;
	}

	public String getView() {
		return view;
	}
	
	public String getUri() {
		return uri;
	}

}
