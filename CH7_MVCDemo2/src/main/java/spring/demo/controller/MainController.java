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
import spring.demo.model.Members;
import spring.demo.service.DistrictsService;
import spring.demo.service.MemberService;
import spring.demo.service.ProvincesService;

@Controller
public class MainController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private ProvincesService provincesService;
	
	@RequestMapping("/")
	public ModelAndView index(){
		
		return new ModelAndView("redirect:index");
	}
	
	@RequestMapping("/ajax")
    public ModelAndView helloAjaxTest(@RequestParam String message) {
        return new ModelAndView("ajax", "message", message);
    }
	
	@RequestMapping(value="/index")
	public ModelAndView index2(Map<String,Object> map){
		List members =  memberService.getAllMember();
		Members listMembers = new Members();
		map.put("member", new Member());
		map.put("members", members);
		map.put("listMembers", listMembers);
		map.put("provincesList", Address.getProvincesList(provincesService));
			
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/excel")
	public ModelAndView indexExcel(Map<String,Object> map){
		List members =  memberService.getAllMember();
		Members listMembers = new Members();
		map.put("member", new Member());
		map.put("members", members);
		map.put("listMembers", listMembers);
		map.put("provincesList", Address.getProvincesList(provincesService));
		map.put("provincesOpt", Address.getProvincesOptions(provincesService));
			
		return new ModelAndView("indexExcel");
	}
	
	@RequestMapping(value="/excelAJS")
	public ModelAndView indexExcelAJS(Map<String,Object> map){
		List members =  memberService.getAllMember();
		map.put("member", new Member());
		map.put("members", members);
		map.put("provincesList", Address.getProvincesList(provincesService));
		map.put("provincesOpt", Address.getProvincesOptions(provincesService));
			
		return new ModelAndView("indexExcelAJS");
	}
}
