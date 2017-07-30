package com.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class WelcomeController {

	private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	
/*	@RequestMapping("/")
	public String welcome() {
		return "index";
 
	}*/
	@RequestMapping(value = "/")
	public ModelAndView welcome() {
 
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
 
		return model;
 
	}
 
}