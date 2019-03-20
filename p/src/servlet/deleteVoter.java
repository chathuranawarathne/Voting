package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.dbConnectr;

/**
 * Servlet implementation class deleteVoter
 */
public class deleteVoter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteVoter() {
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
		
		String sql = "DELETE FROM `voter` WHERE `voter`.`VoterID` = '"+Vid+"'";
			int result=0;
		
		try {
			con = new dbConnectr().Connect();
			ps = con.prepareStatement(sql);
			result=ps.executeUpdate();
			System.out.println(ps);
			System.out.println(result);
			String re ="Delete successfully";
			request.setAttribute("delete", re);
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
