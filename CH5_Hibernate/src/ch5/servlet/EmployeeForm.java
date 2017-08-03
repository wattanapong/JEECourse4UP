package ch5.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import ch5.model.Employees;

/**
 * Servlet implementation class EmployeesDemo
 */
@WebServlet("/emp/form.xxx")
public class EmployeeForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Session s ;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int start = 0,max = 20;

		try {
			start = Integer.parseInt(request.getParameter("start"));
			max = Integer.parseInt(request.getParameter("max"));
		} catch (Exception e1) {
		
		}
		
		try {
			this.Connect();
			
			Query query = s.createQuery("select count(*) from Employees");
			long size = (long) query.uniqueResult();
			request.setAttribute("size", size );
			
			query = s.createQuery("from Employees");
			
			query.setFirstResult(start);
			query.setMaxResults(max);
			
			List employees = query.list();
			request.setAttribute("employees", employees );
			request.setAttribute("start", start );	
			request.setAttribute("max", max );
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/emp/index.jsp").forward(request, response);
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
