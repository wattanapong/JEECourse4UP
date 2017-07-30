package spring.demo.repository;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.demo.dao.MemberDao;
import spring.demo.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Member member) {
		session.getCurrentSession().save(member);
	}

	@Override
	public void edit(Member member) {
		session.getCurrentSession().update(member);
	}

	@Override
	public void delete(int id) {
		session.getCurrentSession().delete(getMember(id));
	}

	@Override
	public Member getMember(int id) {
		return (Member) session.getCurrentSession().get(Member.class, id);
	}

	@Override
	public List getAllMember() {
		// TODO Auto-generated method stub
	return session.getCurrentSession().createQuery("from Member").list();
	}
	
	@Override
	public List getAllMember(Member member) {
		/*Criteria cr = session.getCurrentSession().createCriteria(Member.class);
		
		if (member.getAddress().equals(null))*/
		
	return session.getCurrentSession().createQuery("from Member").list();
	}
}
