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
 * Servlet implementation class AupdateParty
 */
public class AupdateParty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AupdateParty() {
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
		String partyid = request.getParameter("partyid");
		String clm=request.getParameter("clm");
		String value =request.getParameter("value");
		System.out.println("post eke");

		Connection con =null;
		PreparedStatement ps = null;
		int result;
		String sql =" UPDATE `parties` SET `"+clm+"` = '"+value+"' WHERE `parties`.`pid` = '"+partyid+"'";
		
			try {
				con = new dbConnectr().Connect();
				ps=con.prepareStatement(sql);
				result= ps.executeUpdate();
				System.out.println(ps);
				System.out.println(result);
				String re ="Update successfully";
				request.setAttribute("update", re);
				RequestDispatcher  rd = request.getRequestDispatcher("/AshowParties.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				String re ="Update Failed";
				request.setAttribute("update", re);
				RequestDispatcher  rd = request.getRequestDispatcher("/AshowParties.jsp");
				rd.forward(request, response);
				e.printStackTrace();
			}
	}

}
