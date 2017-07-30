package spring.demo.service;

import java.util.List;

import spring.demo.model.Member;

public interface MemberService {
	public void add(Member member);
	public void edit(Member member);
	public void delete(int id);
	public Member getMember(int id);
	public List getAllMember();

}
