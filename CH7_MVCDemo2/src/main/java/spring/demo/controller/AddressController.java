package spring.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.demo.address.Address;
import spring.demo.model.Member;
import spring.demo.service.AmphuresService;
import spring.demo.service.DistrictsService;
import spring.demo.service.GeographyService;
import spring.demo.service.MemberService;
import spring.demo.service.ProvincesService;
import spring.demo.service.ZipcodesService;

@Controller
public class AddressController {
	@Autowired
	AmphuresService amphuresService;

	@Autowired
	ProvincesService provincesService;

	@Autowired
	DistrictsService districtsService;

	@RequestMapping(value = "/address/amphures")
	public ModelAndView amphures(@RequestParam int id, Map<String, Object> map) {
		map.put("amphuresList", amphuresService.getAllAmphures(id));

		return new ModelAndView("address/amphures");
	}

	@RequestMapping(value = "/address/districts")
	public ModelAndView districts(@RequestParam int id, @RequestParam(required = false, defaultValue = "0") int All,
			@RequestParam(required = false, defaultValue = "") String disabled, Map<String, Object> map) {
		map.put("districtsList", districtsService.getAllDistricts(id));
		map.put("All", All );
		map.put("disabled", disabled);
		return new ModelAndView("address/districts");
	}

	@RequestMapping(value = "/address/DropDown")
	public ModelAndView DropDown(@RequestParam int districtId, @RequestParam int amphurId,
			@RequestParam(required = false, defaultValue = "") String disabled, @RequestParam int provinceId, Map<String, Object> map) {
		map.put("districtsList", districtsService.getAllDistricts(amphurId));
		map.put("amphuresList", amphuresService.getAllAmphures(provinceId));
		map.put("provincesList", provincesService.getAllProvinces());
		map.put("districtId", districtId);
		map.put("amphurId", amphurId);
		map.put("provinceId", provinceId);
		map.put("disabled", disabled);
		return new ModelAndView("address/dropdownAddress");
	}
}
