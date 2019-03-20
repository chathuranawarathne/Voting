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
 * Servlet implementation class AsearchParty
 */
public class AsearchParty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsearchParty() {
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
		System.out.println("post search");
		String party =request.getParameter("party");
		
		Connection con =null;
		PreparedStatement ps = null;
		
		String sql = "Select * FROM `parties` WHERE `parties`.`pid` = '"+party+"'";
		
		try {
			con = new dbConnectr().Connect();
			ps = con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			
			rs.next();
			request.setAttribute("PartyID",rs.getString(1) );
			request.setAttribute("Partyname",rs.getString(2) );
			request.setAttribute("Result",rs.getString(3) );
			RequestDispatcher  rd = request.getRequestDispatcher("/AshowParties.jsp");
			rd.forward(request, response);
			
		
			
		} catch (Exception e1) {
		
			e1.printStackTrace();
			String re ="Invalid party ID";
			request.setAttribute("delete", re);
			RequestDispatcher  rd = request.getRequestDispatcher("/AshowParties.jsp");
			rd.forward(request, response);
		}
	}

}
