

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.dao.EmployeeServiceImpl;
import com.employee.model.Employee;

/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet { 
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddEmployee() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		float salary=Float.parseFloat(request.getParameter("salary"));
		System.out.println(name+" "+salary);
		EmployeeServiceImpl impl=new EmployeeServiceImpl();
		Employee employee=new Employee();
		employee.setName(name);
		employee.setSalary(salary);
		impl.addEmployee(employee);
		response.sendRedirect("display.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
