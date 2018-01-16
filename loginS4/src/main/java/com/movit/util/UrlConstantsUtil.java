package com.movit.util;

import javax.servlet.http.HttpServletRequest;

public class UrlConstantsUtil {

    public final static String LOGOUT_URL = "movit/login/logout";

    public static String getLogoutUrl(HttpServletRequest httpRequest) {
	String path = httpRequest.getContextPath();
	String basePath = httpRequest.getScheme() + "://"
		+ httpRequest.getServerName() + ":"
		+ httpRequest.getServerPort() + path + "/";
	return basePath + LOGOUT_URL;
    }
}
