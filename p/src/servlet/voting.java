package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.dbConnectr;
import models.Admin;

/**
 * Servlet implementation class voting
 */
public class voting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public voting() {
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

		String clm=request.getParameter("vote");
		int result = 0;
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("username"));
		System.out.println("post voting eke");

		
		Connection con =null;
		PreparedStatement ps = null;
		///////////////////////////////////////
		
		
		
		
		
		
		Connection conn =null;
	    ps = null;
		String sql4 ="INSERT INTO votes(NIC) VALUES ('"+session.getAttribute("username")+"')";
		
		try {
			conn = new dbConnectr().Connect();			
		    ps=conn.prepareStatement(sql4);
		    
			System.out.println(ps);
			int resultu=ps.executeUpdate();
			System.out.println(resultu);
			
				//////////////////
		
			String sql = "Select result	 FROM `parties` WHERE `parties`.`pname` = '"+clm+"'";
			
			try {
				con = new dbConnectr().Connect();
				ps = con.prepareStatement(sql);
				ResultSet rs= ps.executeQuery();
				System.out.println(ps);
				rs.next();
				result=rs.getInt(1);
				System.out.println(result);
				
				
			
				
			} catch (Exception e1) {
			
				e1.printStackTrace();
				
			}
			result=result+1;
		//	----------------------------------------------------------------------------------
			

			 con =null;
			 ps = null;
			 int result1;
		
			String sql1 =" UPDATE `parties` SET `result` = '"+result+"' WHERE `parties`.`pname` = '"+clm+"'";
			
				try {
					con = new dbConnectr().Connect();
					ps=con.prepareStatement(sql1);
					result1= ps.executeUpdate();
					System.out.println(ps);
					
					String re ="You have voted successfully";
					request.setAttribute("update", re);
					RequestDispatcher  rd = request.getRequestDispatcher("/votesuccess.jsp");
					rd.forward(request, response);
					
				} catch (Exception e) {
					String re ="Failed";
					request.setAttribute("update", re);
					RequestDispatcher  rd = request.getRequestDispatcher("/votesuccess.jsp");
					rd.forward(request, response);
					e.printStackTrace();
				}
			
			
			
			//////////////////////
			
		
		} catch (SQLException e) {
			System.out.println(e);
			String re ="you have already voted ";
			request.setAttribute("Succe", re);
			RequestDispatcher  rd = request.getRequestDispatcher("/Home.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
	/*	
		String sql = "Select result	 FROM `parties` WHERE `parties`.`pname` = '"+clm+"'";
		
		try {
			con = new dbConnectr().Connect();
			ps = con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			System.out.println(ps);
			rs.next();
			result=rs.getInt(1);
			System.out.println(result);
			
			
		
			
		} catch (Exception e1) {
		
			e1.printStackTrace();
			
		}
		result=result+1;
	//	----------------------------------------------------------------------------------
		

		 con =null;
		 ps = null;
		 int result1;
	
		String sql1 =" UPDATE `parties` SET `result` = '"+result+"' WHERE `parties`.`pname` = '"+clm+"'";
		
			try {
				con = new dbConnectr().Connect();
				ps=con.prepareStatement(sql1);
				result1= ps.executeUpdate();
				System.out.println(ps);
				
				String re ="You have voted successfully";
				request.setAttribute("update", re);
				RequestDispatcher  rd = request.getRequestDispatcher("/votesuccess.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				String re ="Failed";
				request.setAttribute("update", re);
				RequestDispatcher  rd = request.getRequestDispatcher("/votesuccess.jsp");
				rd.forward(request, response);
				e.printStackTrace();
			}*/
	}

}
