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
 * Servlet implementation class Singer
 */
@WebServlet("/Singer")
public class Singer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Singer() {
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
			String em=request.getParameter("em");
			String pwd=request.getParameter("pwd");
		    System.out.println(id);
		    System.out.println(nm);
		    System.out.println(mb);
		    System.out.println(add);
		    System.out.println(em);
		    System.out.println(pwd);
		    PrintWriter out=response.getWriter();
			  try
			  { 
				  Class.forName("com.mysql.jdbc.Driver");
			      java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/music_library","root","root");
				   PreparedStatement ps=((java.sql.Connection) con).prepareStatement("insert into singer(singer_id,singer_name,singer_mobile,singer_address,singer_email,singer_pwd)values(?,?,?,?,?,?)");			   
				   ps.setString(1,id);
				   ps.setString(2,nm);
				   ps.setString(3,mb);
				   ps.setString(4,add); 
				   ps.setString(5,em);
				   ps.setString(6,pwd);
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
