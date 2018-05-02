package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
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
		 String id=request.getParameter("id");
			
			String nm=request.getParameter("nm");
			String mb=request.getParameter("mb");
			String add=request.getParameter("add");
		    System.out.println(id);
		    System.out.println(nm);
		    System.out.println(mb);
		    System.out.println(add);
		    PrintWriter out=response.getWriter();
			  try
			  { 
				  Class.forName("com.mysql.jdbc.Driver");
			      java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/music_library","root","root");
				   PreparedStatement ps=((java.sql.Connection) con).prepareStatement("insert into user(user_id,user_name,user_mobile,user_address)values(?,?,?,?)");			   
				   ps.setString(1,id);
				   ps.setString(2,nm);
				   ps.setString(3,mb);
				   ps.setString(4,add); 
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
