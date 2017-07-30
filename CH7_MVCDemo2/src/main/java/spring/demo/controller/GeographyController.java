package spring.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.demo.model.Geography;
import spring.demo.service.GeographyService;

@Controller
public class GeographyController {

	@Autowired
	GeographyService geographyService;

	@RequestMapping("/geography")
	public ModelAndView Main(Map<String, Object> map) {
		Geography geography = new Geography();
		map.put("geography",geography);
		map.put("geographyList", geographyService.getAllGeography());
		ModelAndView model = new ModelAndView("/geography/index");
		return model;

	}

	@RequestMapping(value = "/geography.do", method = RequestMethod.POST)
	public ModelAndView doActions(@ModelAttribute Geography geography, BindingResult result, @RequestParam String action,
			Map<String, Object> map) {
		ModelAndView model = new ModelAndView("/geography/index");
		Geography geographyResult = new Geography();
		switch (action.toLowerCase()) { // only in Java7 you can put String in
										// switch
		case "add":
			geographyService.add(geography);
			geographyResult = geography;
			break;
		case "edit":
			geographyService.edit(geography);
			geographyResult = geography;
			break;
		case "delete":
			geographyService.delete(geography.getId());
			geographyResult = new Geography();
			break;
		case "search":
			Geography searchedgeography = geographyService.getGeography(geography.getId());
			geographyResult = searchedgeography != null ? searchedgeography : new Geography();
			break;
		}
		map.put("geography", geographyResult);
		map.put("geographyList", geographyService.getAllGeography());
		//return "redirect:/geography";
		return model;
	}
}
