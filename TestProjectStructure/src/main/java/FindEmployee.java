

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.dao.EmployeeServiceImpl;
import com.java.dbConnection.ConnectionFactory;

/**
 * Servlet implementation class FindEmployee
 */
@WebServlet("/FindEmployee")
public class FindEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		EmployeeServiceImpl impl=new EmployeeServiceImpl();
		String name=request.getParameter("name");
		try
		{
		Connection connection=ConnectionFactory.getConnection();
		Statement statement=connection.createStatement();
		ResultSet rs=statement.executeQuery("select * from employee where name='"+name+"'");
		while(rs.next())
		{
			out.println(rs.getFloat(3));
		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
