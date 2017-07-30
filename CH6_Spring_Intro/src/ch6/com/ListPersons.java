package ch6.com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch6.com.person.Housekeeper;
import ch6.com.person.Staff;
import ch6.com.person.Student;
import ch6.com.person.Teacher;
import ch6.person.Person;

/**
 * Servlet implementation class EmployeesDemo
 */
@WebServlet("/")
public class ListPersons extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Person> students;
	List<Person> teachers;
	List<Person> staffes;
	List<Person> housekeepers;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		request.setAttribute("allperson", showPerson(type));
		getServletContext().getRequestDispatcher("/cforeachObj.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private List<Person> showPerson(String type) {
		setPerson();
		if (type == null )
			return null;
		else if (type.equals("student"))
			return this.students;
		else if (type.equals("teacher"))
			return this.teachers;
		else if (type.equals("staff"))
			return this.staffes;
		else if (type.equals("housekeeper"))
			return this.housekeepers;
		
			return null;
	}

	private void setPerson() {
		students = new ArrayList<Person>();
		students.add(new Student("ณัฐวุฒิ", "จันทาพูน"));
		students.add(new Student("ธนพล", "สุขแจ่ม"));
		students.add(new Student("นิพิษฐา", "กันทิยะ"));
		students.add(new Student("พุทธิพัทธ์", "มีอ่วม"));

		teachers = new ArrayList<Person>();
		teachers.add(new Teacher("ศรัณย์", "เชื้อผู้ดี"));
		teachers.add(new Teacher("สยามรัฐ", "แก้วตา"));
		teachers.add(new Teacher("พันธกานต์", "ต๊ะลิสังวาลย์"));
		teachers.add(new Teacher("พิชัย", "พิพัฒน์ธนพงษ์"));

		staffes = new ArrayList<Person>();
		staffes.add(new Staff("ฐากูร", "อุปธิ"));
		staffes.add(new Staff("ทศพล", "วงศ์วี"));
		staffes.add(new Staff("ทักษิณ", "พรวัฒนเวทย์"));
		staffes.add(new Staff("รณกรณ์", "วรเมธาพิพัฒน์"));

		housekeepers = new ArrayList<Person>();
		housekeepers.add(new Housekeeper("วศิน", "มูลเมือง"));
		housekeepers.add(new Housekeeper("สุรเชษฐ์", "กันทะเนตร"));
		housekeepers.add(new Housekeeper("วรพล", "บุญช่วย"));

	}

}
