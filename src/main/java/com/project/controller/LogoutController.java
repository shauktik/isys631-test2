package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("session")
public class LogoutController {
	

	
	@Autowired
	HttpSession session;

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
	
	@RequestMapping(value="/logout")
	public String logout(){
		
		if(session != null){
			session.invalidate();
		}
		
		return "index";
		
	}

}
