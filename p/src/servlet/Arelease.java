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
 * Servlet implementation class Arelease
 */
public class Arelease extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Arelease() {
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
		String result1 = request.getParameter("release");
		
		System.out.println(result1);
		String rout ="on";
		
		if(result1.equals(rout)) {
			
		

		Connection con =null;
		PreparedStatement ps = null;
		int result;
		String sql =" UPDATE `Release` SET `confirm` = '1' WHERE `Release`.`ID` = 'result'";
		
			try {
				con = new dbConnectr().Connect();
				ps=con.prepareStatement(sql);
				result= ps.executeUpdate();
				System.out.println(ps);
				System.out.println(result);
				String re ="Update succesfully";
				request.setAttribute("update", re);
				RequestDispatcher  rd = request.getRequestDispatcher("/Aresults.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				String re ="Update Failed";
				request.setAttribute("update", re);
				RequestDispatcher  rd = request.getRequestDispatcher("/Aresults.jsp");
				rd.forward(request, response);
				e.printStackTrace();
			}
		}
		else {
			Connection con =null;
			PreparedStatement ps = null;
			int result;
			String sql =" UPDATE `Release` SET `confirm` = '0' WHERE `Release`.`ID` = 'result'";
			
				try {
					con = new dbConnectr().Connect();
					ps=con.prepareStatement(sql);
					result= ps.executeUpdate();
					System.out.println(ps);
					System.out.println(result);
					String re ="Update succesfully";
					request.setAttribute("update", re);
					RequestDispatcher  rd = request.getRequestDispatcher("/Aresults.jsp");
					rd.forward(request, response);
					
				} catch (Exception e) {
					String re ="Update Failed";
					request.setAttribute("update", re);
					RequestDispatcher  rd = request.getRequestDispatcher("/Aresults.jsp");
					rd.forward(request, response);
					e.printStackTrace();
				}
		}
	}

}
