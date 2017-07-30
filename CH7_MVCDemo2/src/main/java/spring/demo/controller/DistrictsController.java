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

import spring.demo.model.Amphures;
import spring.demo.model.Districts;
import spring.demo.model.Geography;
import spring.demo.model.Districts;
import spring.demo.model.Provinces;
import spring.demo.model.Zipcodes;
import spring.demo.service.AmphuresService;
import spring.demo.service.DistrictsService;
import spring.demo.service.GeographyService;
import spring.demo.service.DistrictsService;
import spring.demo.service.ProvincesService;
import spring.demo.service.ZipcodesService;

@Controller
public class DistrictsController {

	@Autowired
	AmphuresService amphuresService;

	@Autowired
	ProvincesService provincesService;

	@Autowired
	ZipcodesService zipcodesService;

	@Autowired
	GeographyService geographicService;

	@Autowired
	DistrictsService districtsService;

	@RequestMapping("/districts")
	public ModelAndView Main(Map<String, Object> map) {
		
		Districts districts = new Districts();
		map.put("districts", districts);
		map.put("districtsList", districtsService.getAllDistricts());

		map.put("amphuresList", getAmphuresList());
		map.put("provincesList", getProvincesList());
		map.put("geoGraphyList", getGeographyList());
		map.put("zipcodesList", getZipcodesList());

		ModelAndView model = new ModelAndView("/districts/index");
		return model;

	}

	

	@RequestMapping(value = "/districts.do", method = RequestMethod.POST)
	public ModelAndView doActions(@ModelAttribute Districts districts, BindingResult result, @RequestParam String action,
			Map<String, Object> map) {
		ModelAndView model = new ModelAndView("/districts/index");
		Districts districtsResult = new Districts();
		switch (action.toLowerCase()) { // only in Java7 you can put String in
										// switch
		case "add":
			districtsService.add(districts);
			districtsResult = districts;
			break;
		case "edit":
			districtsService.edit(districts);
			districtsResult = districts;
			break;
		case "delete":
			districtsService.delete(districts.getDistrictId());
			districtsResult = new Districts();
			break;
		case "search":
			Districts searcheddistricts = districtsService.getDistricts(districts.getDistrictId());
			districtsResult = searcheddistricts != null ? searcheddistricts : new Districts();
			break;
		}
		map.put("districts", districtsResult);
		map.put("districtsList", districtsService.getAllDistricts());

		map.put("amphuresList", getAmphuresList());
		map.put("provincesList", getProvincesList());
		map.put("geoGraphyList", getGeographyList());
		map.put("zipcodesList", getZipcodesList());
		map.put("zipcodes", getZipcodes(districts.getDistrictCode()));
		// return "redirect:/districts";
		return model;
	}
	
	@RequestMapping(value = "/districts/view/{id}")
	public ModelAndView view(@PathVariable("id") int id, Map<String, Object> map) {
		ModelAndView model = new ModelAndView("/districts/view");
		String msg = "";
		try {
			Districts districts = districtsService.getDistricts(id);
			Zipcodes zipcodes = zipcodesService.getZipcodesBydistrictscode(districts.getDistrictCode());
			map.put("districts", districts);
			map.put("zipcodes", zipcodes);
		} catch (Exception e) {
			msg = e.toString();
		}
		map.put("msg", msg);
		return model;
	}
	
	private Map<String, String> getAmphuresList() {
		Map<String, String> map = new HashMap<>();
		List<Amphures> amphuresList = amphuresService.getAllAmphures();
		for (Amphures amphures : amphuresList) {
			map.put( amphures.getAmphurId() + "", amphures.getAmphurName() );
		}
		return map;
	}

	private Map<String, String> getProvincesList() {
		Map<String, String> map = new HashMap<>();
		List<Provinces> provincesList = provincesService.getAllProvinces();
		for (Provinces provinces : provincesList) {
			map.put(provinces.getprovinceId() + "", provinces.getProvinceName());
		}
		return map;
	}

	private Map<String, String> getZipcodesList() {
		Map<String, String> map = new HashMap<>();
		List<Zipcodes> zipcodesList = zipcodesService.getAllZipcodes();	
	for (Zipcodes zipcodes : zipcodesList) {
			map.put( zipcodes.getDistrictCode() + "", zipcodes.getZipcode());
		}

		return map;
	}
	
	private Map<String, Object> getZipcodes(String code) {
		Map<String, Object> map = new HashMap<>();

			Zipcodes zipcodes = zipcodesService.getZipcodesBydistrictscode(code);
			if (zipcodes == null) zipcodes = new Zipcodes();
			
			map.put("zipcodes", zipcodes);

		return map;
	}

	private Map<String, String> getGeographyList() {
		Map<String, String> map = new HashMap<>();
		List<Geography> geographyList = geographicService.getAllGeography();
		for (Geography geography : geographyList) {
			map.put(geography.getId() + "", geography.getGeoName());
		}
		return map;
	}
}
