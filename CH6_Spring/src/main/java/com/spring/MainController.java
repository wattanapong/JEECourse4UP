package com.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.model.Student;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("name","Wattanapong S");
		return "index";
	}
	
	@RequestMapping("/student")
	public String student(Model model,@ModelAttribute Student student) {
		model.addAttribute("student",student);
		return "student/index";
	}
}
