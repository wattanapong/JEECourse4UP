package spring.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.demo.model.Geography;
import spring.demo.model.Provinces;
import spring.demo.service.GeographyService;
import spring.demo.service.ProvincesService;

@Controller
public class ProvincesController {

	@Autowired
	ProvincesService provincesService;
	
	@Autowired
	GeographyService geographyService;

	@RequestMapping("/provinces")
	public ModelAndView Main(Map<String, Object> map) {
		Provinces provinces = new Provinces();
		map.put("provinces",provinces);
		map.put("provincesList", provincesService.getAllProvinces());
		
		map.put("geographyList", getGeographyList());
		
		ModelAndView model = new ModelAndView("/provinces/index");
		return model;
	}
	
	@RequestMapping("/provinces/view{id}")
	public ModelAndView Main(@PathVariable("id") int id, Map<String, Object> map) {
		Provinces provinces = provincesService.getProvinces(id);
		map.put("provinces", provinces);
		map.put("amphureses", provinces.getAmphureses() );
		ModelAndView model = new ModelAndView("/provinces/view");
		return model;
	}

	@RequestMapping(value = "/provinces.do", method = RequestMethod.POST)
	public ModelAndView doActions(@ModelAttribute Provinces provinces, BindingResult result, @RequestParam String action,
			Map<String, Object> map) {
		ModelAndView model = new ModelAndView("/provinces/index");
		Provinces provincesResult = new Provinces();
		switch (action.toLowerCase()) { // only in Java7 you can put String in
										// switch
		case "add":
			provincesService.add(provinces);
			provincesResult = provinces;
			break;
		case "edit":
			provincesService.edit(provinces);
			provincesResult = provinces;
			break;
		case "delete":
			provincesService.delete( provinces.getprovinceId() );
			provincesResult = new Provinces();
			break;
		case "search":
			Provinces searchedprovinces = provincesService.getProvinces(provinces.getprovinceId());
			provincesResult = searchedprovinces != null ? searchedprovinces : new Provinces();
			break;
		}
		map.put("provinces", provincesResult);
		map.put("provincesList", provincesService.getAllProvinces());
		
		map.put("geographyList", getGeographyList());
		
		//return "redirect:/provinces";
		return model;
	}
	
	private Map<String, String> getGeographyList(){
		Map<String, String> map = new HashMap<>();
		List<Geography> geographyList =  geographyService.getAllGeography();
		for (Geography geography : geographyList) {
			map.put(geography.getId()+"", geography.getGeoName());
		}
		return map;
	}
}
