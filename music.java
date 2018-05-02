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

import com.sun.corba.se.pept.transport.Connection;

/**
 * Servlet implementation class music
 */
@WebServlet("/music")
public class music extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public music() {
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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       String id=request.getParameter("id");
		
		String type=request.getParameter("type");
		String desc=request.getParameter("desc");
		
	    System.out.println(id);
	    System.out.println(type);
	    System.out.println(desc);
	    PrintWriter out=response.getWriter();
		  try
		  { 
			  Class.forName("com.mysql.jdbc.Driver");
		      java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/music_library","root","root");
			   PreparedStatement ps=((java.sql.Connection) con).prepareStatement("insert into musics(music_id,music_type,music_desc)values(?,?,?)");			   
			   ps.setString(1,id);
			   ps.setString(2,type);
			   ps.setString(3,desc);
			   
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

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
