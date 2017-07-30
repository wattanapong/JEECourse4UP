import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import ch5.model.Employees;

public class Main {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties()).build();
		SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		Session s = sessionFactory.openSession();
		
		Employees emp = (Employees) s.get(Employees.class, 10001);
		
		System.out.println(emp.getEmpNo());
		System.out.println(emp.getFirstName());
		System.out.println(emp.getLastName());
	}
}
