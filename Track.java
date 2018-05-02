package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.pept.transport.Connection;

import java.sql.*;
/**
 * Servlet implementation class Track
 */
@WebServlet("/Track")
public class Track extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Track() {
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
//		 String desc=request.getParameter("desc");
//			
//			String nm=request.getParameter("name");
//			String ms=request.getParameter("ms");
//			String mid=request.getParameter("mid");
//			String add=request.getParameter("add");
//			System.out.println(desc);
//		    System.out.println(nm);
//		    System.out.println(ms);
//		    System.out.println(mid);
//		    System.out.println(add);
//		    PrintWriter out=response.getWriter();
//			  try
//			  { 
//				  Class.forName("com.mysql.jdbc.Driver");
//			      java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/music_library","root","root");
//				   PreparedStatement ps=((java.sql.Connection) con).prepareStatement("insert into track(trk_id,trk_name,trk_desc,trk_music,trk_type)values(?,?,?,?,?)");			   
//				   ps.setString(1,mid);
//				   ps.setString(2,nm);
//				   ps.setString(3,desc);
//				   ps.setString(4,ms);
//				   ps.setString(5,add);
//				int i=ps.executeUpdate();
//				    
//				System.out.println(ps );
//				    if(i==1)
//				    {
//				    	out.println("Registration Successfully..!");
//				    }
//				    else
//				    {
//
//				    	out.println("Registration Not Successfully..!");
//				    }
//				    
//				    System.out.println("Working...!");
//			  }
//			  catch(Exception ref)
//			  {
//				  System.out.println(ref);
//			  }
//
      
		PrintWriter out=response.getWriter();
		out.print("<div class='container'> <h2>Song Listing</h2>");
		 try {
			    RequestDispatcher rd=request.getRequestDispatcher("audio.html");
			    rd.include(request, response);
		
			 Class.forName("com.mysql.jdbc.Driver");
			 	java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/music_library","root","root");
				  			//   PreparedStatement ps =((java.sql.Connection) con).prepareStatement("select * from track ");	   
			   PreparedStatement ps=con.prepareStatement("select * from  track");
			  
			    ResultSet rs=ps.executeQuery();  
			    out.print("<center><table align='center'><tr>");
			    while(rs.next()){  
					out.print("<td><h3 style='color:white;'> "+rs.getString(3)+"</h3></td>");
					out.print("<td style=''><audio controls loop> <source src="+rs.getString(4)+" ></audio></td></tr>");
				}
				
			    out.print("</table></center>");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
