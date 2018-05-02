package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login_id =request.getParameter("id");

		String l_name=request.getParameter("nm");
		
		String l_password=request.getParameter("pwd");
		  PrintWriter out=response.getWriter();
		  try
		  {
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/music_library","root","root");
			   PreparedStatement ps=con.prepareStatement("insert into login(login_id,l_name,l__password) values(?,?,?)");			   
			   ps.setString(1,login_id);
			   ps.setString(2,l_name);
			   ps.setString(3,l_password);
			   
			   
			   
			int i=ps.executeUpdate();
			    
			System.out.println(ps );
			    if(i==1)
			    {
			    	out.println("Registration Successfully..!");
			    }
			    else
			    {

			    	out.println("Registration Not Successfully..!");
			    }
			    
			    System.out.println("Working...!");
		  }
		  catch(Exception ref)
		  {
			  System.out.println(ref);
		  }

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
