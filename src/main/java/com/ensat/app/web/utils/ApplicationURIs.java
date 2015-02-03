package com.ensat.app.web.utils;

public abstract class ApplicationURIs {
	public final static String NOT_FOUND = "/404";
	public final static String HOME = "/";
	public final static String LOGIN = "/login";
	public final static String LOGIN_ERROR = "/login-error";
	public final static String LOGOUT = "/logout";
	private final static String ADMIN_ROOT_PATH = "/admin";
	public final static String USERS_ADMIN_LIST = ADMIN_ROOT_PATH + "/utilisateurs/list";
	public final static String USERS_ADMIN_NEW = ADMIN_ROOT_PATH + "/utilisateurs/new";
	public final static String USERS_ADMIN_VIEW = ADMIN_ROOT_PATH + "/utilisateurs/view";
	public final static String USERS_ADMIN_EDIT = ADMIN_ROOT_PATH + "/utilisateurs/edit";
	public final static String USERS_ADMIN_DELETE = ADMIN_ROOT_PATH + "/utilisateurs/delete";
}
