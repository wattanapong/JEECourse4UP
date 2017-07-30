package spring.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.demo.model.Districts;
import spring.demo.model.Geography;
import spring.demo.model.Amphures;
import spring.demo.model.Provinces;
import spring.demo.model.Zipcodes;
import spring.demo.service.DistrictsService;
import spring.demo.service.GeographyService;
import spring.demo.service.AmphuresService;
import spring.demo.service.ProvincesService;
import spring.demo.service.ZipcodesService;

@Controller
public class AmphuresController {

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

	@RequestMapping("/amphures")
	public ModelAndView Main(Map<String, Object> map) {
		Amphures amphures = new Amphures();
		map.put("amphures", amphures);
		map.put("amphuresList", amphuresService.getAllAmphures());

		map.put("provincesList", getProvincesList());
		map.put("geoGraphyList", getGeographyList());
		//map.put("zipcodesList", getZipcodesList());

		ModelAndView model = new ModelAndView("/amphures/index");
		return model;

	}

	@RequestMapping(value = "/amphures.do", method = RequestMethod.POST)
	public ModelAndView doActions(@ModelAttribute Amphures amphures, BindingResult result, @RequestParam String action,
			Map<String, Object> map) {
		ModelAndView model = new ModelAndView("/amphures/index");
		Amphures amphuresResult = new Amphures();
		switch (action.toLowerCase()) { // only in Java7 you can put String in
										// switch
		case "add":
			amphuresService.add(amphures);
			amphuresResult = amphures;
			break;
		case "edit":
			amphuresService.edit(amphures);
			amphuresResult = amphures;
			break;
		case "delete":
			amphuresService.delete(amphures.getAmphurId());
			amphuresResult = new Amphures();
			break;
		case "search":
			Amphures searchedamphures = amphuresService.getAmphures(amphures.getAmphurId());
			amphuresResult = searchedamphures != null ? searchedamphures : new Amphures();
			break;
		}
		map.put("amphures", amphuresResult);
		map.put("amphuresList", amphuresService.getAllAmphures());

		map.put("provincesList", getProvincesList());
		map.put("geoGraphyList", getGeographyList());
		//map.put("zipcodesList", getZipcodesList());

		// return "redirect:/amphures";
		return model;
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
			// districtsService.getDistrictsByCode(zipcodes.getDistrictCode()).getAmphures().getAmphurId()+
			Districts districts = districtsService.getDistrictsByCode(zipcodes.getDistrictCode());
			int id = districts != null ? districts.getDistrictId():0;
			map.put( id + "", zipcodes.getZipcode());
		}

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
