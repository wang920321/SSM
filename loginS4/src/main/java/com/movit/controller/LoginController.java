package com.movit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.movit.entity.User;

@Controller
@RequestMapping(value = "movit/login")
public class LoginController {

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String gotoSuccessPage(User user, HttpServletRequest request) {
	request.getSession().setAttribute("currentUser", user);
	return "success";
    }

    @RequestMapping(value = "/refreshSuccess")
    public String refreshSuccess(User user, HttpServletRequest request) {

	return "success";
    }

    @RequestMapping(value = "/logout")
    public String logout(User user, HttpServletRequest request) {
	return "index";
    }

    @RequestMapping(value = "/removeSession")
    public String removeSession(HttpServletRequest request) {
	request.getSession().removeAttribute("currentUser");
	return "success";
    }

    @RequestMapping(value = "/testFilter")
    public String testFilter(HttpServletRequest request) {
	System.out.println("filter pass!");
	return "success";
    }

}
