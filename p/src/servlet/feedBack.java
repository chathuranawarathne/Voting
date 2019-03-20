package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.dbConnectr;
import models.Admin;

/**
 * Servlet implementation class feedBack
 */
public class feedBack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public feedBack() {
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
		System.out.println("adminReg");
		String name =request.getParameter("name");
		String Subject =request.getParameter("Subject");
		String Email =request.getParameter("Email");
		String Description =request.getParameter("Description");
		
		Admin ad =new Admin();
		
		
		System.out.println(ad);
		
		Connection conn =null;
		PreparedStatement ps = null;
		String sql ="INSERT INTO Feedback(Name, Subject,Email,Description) VALUES (?,?,?,?)";
		
		try {
			conn = new dbConnectr().Connect();
			
				ps=conn.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, Subject);
			ps.setString(3, Email);
			ps.setString(4, Description);

			int result=ps.executeUpdate();
			System.out.println(result);
			if(result==1) {
				String re ="Successfully";
				request.setAttribute("Success", re);
				RequestDispatcher  rd = request.getRequestDispatcher("/feedback.jsp");
				rd.forward(request, response);
			}
			else {
				String re ="try again ";
				request.setAttribute("Success", re);
				RequestDispatcher  rd = request.getRequestDispatcher("/feedback.jsp");
				rd.forward(request, response);
			}
			
		
		} catch (SQLException e) {
			System.out.println(e);
			String re ="Invalid ";
			request.setAttribute("Success", re);
			RequestDispatcher  rd = request.getRequestDispatcher("/feedback.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
	}

}
