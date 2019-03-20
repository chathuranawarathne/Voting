package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.dbConnectr;

/**
 * Servlet implementation class Asearchvoter
 */
public class Asearchvoter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Asearchvoter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post ekta awa");
		String Vid =request.getParameter("voter");
		
		Connection con =null;
		PreparedStatement ps = null;
		
		String sql = "Select * FROM `voter` WHERE `voter`.`VoterID` = '"+Vid+"'";
		
		try {
			con = new dbConnectr().Connect();
			ps = con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			
			rs.next();
			request.setAttribute("VoterID",rs.getString(1) );
			request.setAttribute("Fullname",rs.getString(2) );
			request.setAttribute("NIC",rs.getString(8) );
			request.setAttribute("Mobilenumber",rs.getString(3) );
			request.setAttribute("District",rs.getString(4) );
			request.setAttribute("City",rs.getString(5) );
			request.setAttribute("Email",rs.getString(6) );
			RequestDispatcher  rd = request.getRequestDispatcher("/Ashowvoters.jsp");
			rd.forward(request, response);
			
		
			
		} catch (Exception e1) {
		
			e1.printStackTrace();
			String re ="Invalid voter ID";
			request.setAttribute("delete", re);
			RequestDispatcher  rd = request.getRequestDispatcher("/Ashowvoters.jsp");
			rd.forward(request, response);
		}
	}
	

}
