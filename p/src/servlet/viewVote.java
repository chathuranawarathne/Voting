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
import javax.servlet.http.HttpSession;

import DB.dbConnectr;

/**
 * Servlet implementation class viewVote
 */
public class viewVote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewVote() {
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
		Connection con =null;
		PreparedStatement ps = null;
		
		
		String sql = "Select confirm FROM `Release` WHERE `Release`.`ID` = 'election'";
		
		try {
			con = new dbConnectr().Connect();
			ps = con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			System.out.println(ps);
			rs.next();
			System.out.println(rs.getString(1));
			String rout="1";
			String r = rs.getString(1);
			
				if(r.equals(rout)) {
					System.out.println("1");
					String re="Result";
					request.setAttribute("Name",re );
			RequestDispatcher  rd = request.getRequestDispatcher("/votesuccess.jsp");
			rd.forward(request, response);
			
				}
				else {
					System.out.println("2");
					String re ="Result has not been released yet";
					request.setAttribute("Name",re );
					RequestDispatcher  rd = request.getRequestDispatcher("/vote.jsp");
					rd.forward(request, response);
					
				}
			
		} catch (Exception e1) {
		
			e1.printStackTrace();
			System.out.println(e1);
			String re ="something wrong!";
			request.setAttribute("Name", re);
			RequestDispatcher  rd = request.getRequestDispatcher("/vote.jsp");
			rd.forward(request, response);
		}
	}

}
