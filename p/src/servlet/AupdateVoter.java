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
 * Servlet implementation class AupdateVoter
 */
public class AupdateVoter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AupdateVoter() {
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
		System.out.println("post adeleteadmin");
		String voter = request.getParameter("voter");
		String sname=request.getParameter("value");
		String clm =request.getParameter("clm");
		
		System.out.println(sname);
		System.out.println(clm);

		Connection con =null;
		PreparedStatement ps = null;
		int result;
		String sql =" UPDATE `voter` SET `"+clm+"` = '"+sname+"' WHERE `voter`.`VoterID` = '"+voter+"'";
		
			try {
				con = new dbConnectr().Connect();
				ps=con.prepareStatement(sql);
				result= ps.executeUpdate();
				System.out.println(ps);
				System.out.println(result);
				String re ="Update successfully";
				request.setAttribute("update", re);
				RequestDispatcher  rd = request.getRequestDispatcher("/Ashowvoters.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				String re ="Update Failed";
				request.setAttribute("update", re);
				RequestDispatcher  rd = request.getRequestDispatcher("/Ashowvoters.jsp");
				rd.forward(request, response);
				e.printStackTrace();
			}
	}

}
