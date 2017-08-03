package ch5.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import ch5.model.Employees;

/**
 * Servlet implementation class EmployeesDemo
 */
@WebServlet("/emp/formSearch")
public class EmployeeFormSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Session s ;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empno= "", firstname = "",lastname = "",gender = "";

				empno =request.getParameter("empno");
				firstname = request.getParameter("firstname");
				lastname = request.getParameter("lastname");
				gender = request.getParameter("gender");
		
		try {
			this.Connect();
			
			Query query = s.createQuery("select count(*) from Employees");
			long size = (long) query.uniqueResult();
			
			
			Criteria criteria = s.createCriteria(Employees.class);
			if (firstname != null) criteria.add(Restrictions.like("firstName", firstname,MatchMode.ANYWHERE ));
			if (lastname != null) criteria.add(Restrictions.like("lastName", "%"+lastname+"%"));
			if (gender != null && !gender.equals("ALL")) criteria.add(Restrictions.eq("gender", gender));
			
			List employees = criteria.list();
			request.setAttribute("size", employees.size() );
			
			criteria.setFirstResult(0);
			criteria.setMaxResults(20);
			employees = criteria.list();
			request.setAttribute("employees", employees );
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/emp/indexSearch.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void Connect(){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties()).build();
		SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		s = sessionFactory.openSession();
	}

}
