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
import models.parties;

/**
 * Servlet implementation class AaddParties
 */
public class AaddParties extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AaddParties() {
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
		System.out.println("Post ekat awa");
		String fname =request.getParameter("fname");
		
		parties p = new parties(fname);
		
		
		
		int result =0;
		Connection con =null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO parties(pname) VALUES ('"+p.getFname()+"')";
		
			try {
				con = new dbConnectr().Connect();
				ps = con.prepareStatement(sql);
				System.out.println(ps);
				result=ps.executeUpdate();
				String re ="party added successfully";
				request.setAttribute("Success", re);
				RequestDispatcher  rd = request.getRequestDispatcher("/Aaddparties.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				String re =" Registration fail";
				request.setAttribute("Success", re);
				RequestDispatcher  rd = request.getRequestDispatcher("/Aaddparties.jsp");
				rd.forward(request, response);
				e.printStackTrace();
			}
	}
}


