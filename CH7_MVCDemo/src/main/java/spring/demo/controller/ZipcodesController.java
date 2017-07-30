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

import spring.demo.model.Zipcodes;
import spring.demo.service.ZipcodesService;

@Controller
public class ZipcodesController {

	@Autowired
	ZipcodesService zipcodesService;

	@RequestMapping("/zipcodes")
	public ModelAndView Main(Map<String, Object> map) {
		Zipcodes zipcodes = new Zipcodes();
		map.put("zipcodes",zipcodes);
		map.put("zipcodesList", zipcodesService.getAllZipcodes());
		ModelAndView model = new ModelAndView("/zipcodes/index");
		return model;

	}

	@RequestMapping(value = "/zipcodes.do", method = RequestMethod.POST)
	public ModelAndView doActions(@ModelAttribute Zipcodes zipcodes, BindingResult result, @RequestParam String action,
			Map<String, Object> map) {
		ModelAndView model = new ModelAndView("/zipcodes/index");
		Zipcodes zipcodesResult = new Zipcodes();
		switch (action.toLowerCase()) { // only in Java7 you can put String in
										// switch
		case "add":
			zipcodesService.add(zipcodes);
			zipcodesResult = zipcodes;
			break;
		case "edit":
			zipcodesService.edit(zipcodes);
			zipcodesResult = zipcodes;
			break;
		case "delete":
			zipcodesService.delete(zipcodes.getId());
			zipcodesResult = new Zipcodes();
			break;
		case "search":
			Zipcodes searchedzipcodes = zipcodesService.getZipcodes(zipcodes.getId());
			zipcodesResult = searchedzipcodes != null ? searchedzipcodes : new Zipcodes();
			break;
		}
		map.put("zipcodes", zipcodesResult);
		map.put("zipcodesList", zipcodesService.getAllZipcodes());
		//return "redirect:/zipcodes";
		return model;
	}
}
