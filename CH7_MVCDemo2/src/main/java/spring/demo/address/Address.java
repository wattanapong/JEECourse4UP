package spring.demo.address;

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
import spring.demo.model.Member;
import spring.demo.model.Provinces;
import spring.demo.model.Zipcodes;
import spring.demo.service.DistrictsService;
import spring.demo.service.GeographyService;
import spring.demo.service.AmphuresService;
import spring.demo.service.ProvincesService;
import spring.demo.service.ZipcodesService;


@Controller
public class Address {
	
	public static Map<String, String> getDistrictsList(DistrictsService districtsService) {
		Map<String, String> map = new HashMap<>();
		List<Districts> districtsList = districtsService.getAllDistricts();
		map.put("", "เลือกตำบล");
		for (Districts districts : districtsList) {
			map.put( districts.getDistrictId()+ "", districts.getDistrictName() );
		}
		return map;
	}
	
	public static  Map<String, String> getAmphuresList(AmphuresService amphuresService) {
		Map<String, String> map = new HashMap<>();
		List<Amphures> amphuresList = amphuresService.getAllAmphures();
		map.put("", "เลือกอำเภอ");
		for (Amphures amphures : amphuresList) {
			map.put( amphures.getAmphurId() + "", amphures.getAmphurName() );
		}
		return map;
	}
	
	public static  Map<String, String> getProvincesList(ProvincesService provincesService) {
		Map<String, String> map = new HashMap<>();
		List<Provinces> provincesList = provincesService.getAllProvinces();
		map.put("", "เลือกจังหวัด");
		for (Provinces provinces : provincesList) {
			map.put(provinces.getprovinceId() + "", provinces.getProvinceName());
		}
		return map;
	}
	
	public static  String getProvincesOptions(ProvincesService provincesService) {
		List<Provinces> provincesList = provincesService.getAllProvinces();
		int i =0;
		String opt = "<option>เลือกจังหวัด</option>";
		for (Provinces provinces : provincesList) {
			opt += "<option value='"+provinces.getprovinceId()+"'>"+provinces.getProvinceName()+"</option>";
		}
		return opt;
	}
	
	public static  String getProvincesOptions(ProvincesService provincesService,Member member) {
		List<Provinces> provincesList = provincesService.getAllProvinces();
		int i =0;
		String opt = "<option>เลือกจังหวัด</option>";
		for (Provinces provinces : provincesList) {
			String selected = member.getDistricts().getAmphures().getProvinces().getprovinceId()==provinces.getprovinceId()?"selected":"";
			opt += "<option value='"+provinces.getprovinceId() +"'"+ selected +">"+provinces.getProvinceName()+"</option>";
		}
		return opt;
	}

	public static  Map<String, String> getZipcodesList(ZipcodesService zipcodesService,DistrictsService districtsService) {
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

	public static  Map<String, String> getGeographyList(GeographyService geographicService) {
		Map<String, String> map = new HashMap<>();
		List<Geography> geographyList = geographicService.getAllGeography();
		for (Geography geography : geographyList) {
			map.put(geography.getId() + "", geography.getGeoName());
		}
		return map;
	}
}
