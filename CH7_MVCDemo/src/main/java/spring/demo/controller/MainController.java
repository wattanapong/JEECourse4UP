package spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/index")
	public String index2(){
		return "index";
	}
}
