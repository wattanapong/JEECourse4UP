package spring.demo.controller;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.xerces.internal.util.URI;

import spring.demo.model.Districts;
import spring.demo.model.Member;
import spring.demo.model.Members;
import spring.demo.service.DistrictsService;
import spring.demo.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private DistrictsService districtService;

	@RequestMapping(value = "/member/creates", method = RequestMethod.POST)
	public ModelAndView manages(@ModelAttribute Members members, @RequestParam(required = false) String action,
			Map<String, Object> map) {

		List<Member> listmembers = new ArrayList<Member>();
		for (Member member : members.getMembers()) {
			try {
				if (!member.getUser().isEmpty() && member.getDistricts().getDistrictId() != null) {
					/*
					 * Districts district =
					 * districtService.getDistricts(member.getDistricts
					 * ().getDistrictId()); member.setDistricts(district);
					 * listmembers.add(member);
					 */
					memberService.add(member);
				}
				listmembers = memberService.getAllMember();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		map.put("members", listmembers);

		return new ModelAndView("/member/list");
	}

	@RequestMapping(value = "/member/create", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute Member member, @RequestParam(required = false) String action,
			Map<String, Object> map) {

		List<Member> listmembers = new ArrayList<Member>();
		try {
			if (!member.getUser().isEmpty() && member.getDistricts() != null) {
				/*
				 * Districts district =
				 * districtService.getDistricts(member.getDistricts
				 * ().getDistrictId()); member.setDistricts(district);
				 * listmembers.add(member);
				 */
				if (action.equalsIgnoreCase("add") ) memberService.add(member);
				else if (action.equalsIgnoreCase("update") ) {
					memberService.edit(member);
				}
			}
			listmembers = memberService.getAllMember();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("members", listmembers);

		return new ModelAndView("/member/list");
	}

	@RequestMapping(value = "/member", method = RequestMethod.POST)
	public String manage(@ModelAttribute Member member, @RequestParam(required = false) String action,
			Map<String, Object> map) {
		String msg = "";
		try {
			switch (action.toLowerCase()) {
			case "add":
					
				break;

			case "edit":
				
				break;

			case "delete":
				msg =URLEncoder.encode("ไม่สามารถลบ member#"+member.getId(),"UTF-8");
				memberService.delete(member.getId());
				msg = "";
				break;

			case "search":

				break;

			default:
				break;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		/*List<Member> listmembers = memberService.getAllMember();
		map.put("members", listmembers);*/

		return "redirect:/ajax?message="+msg;
	}
}
