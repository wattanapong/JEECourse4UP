package spring.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.demo.dao.MemberDao;
import spring.demo.model.Member;
import spring.demo.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDAO;

	@Transactional
	public void add(Member member) {
		memberDAO.add(member);
	}

	@Transactional
	public void edit(Member member) {
		memberDAO.edit(member);
	}

	@Transactional
	public void delete(int id) {
		memberDAO.delete(id);
	}

	@Transactional
	public Member getMember(int id) {
		return memberDAO.getMember(id);
	}

	@Transactional
	public List getAllMember() {
		// TODO Auto-generated method stub
		return memberDAO.getAllMember();
	}
	
	@Transactional
	public List getAllMember(Member member) {
		// TODO Auto-generated method stub
		return memberDAO.getAllMember(member);
	}
	
	
}
