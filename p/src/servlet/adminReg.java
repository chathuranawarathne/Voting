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
 * Servlet implementation class adminReg
 */
public class adminReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminReg() {
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
		String fname =request.getParameter("fname");
		String NIC =request.getParameter("NIC");
		String psw =request.getParameter("psw");
		
		Admin ad =new Admin();
		ad.setName(fname);
		ad.setNIC(NIC);
		ad.setPsw(psw);
		
		System.out.println(ad);
		
		Connection conn =null;
		PreparedStatement ps = null;
		String sql ="INSERT INTO Admin(NIC, Name,password) VALUES (?,?,?)";
		
		try {
			conn = new dbConnectr().Connect();
			
				ps=conn.prepareStatement(sql);
			
			ps.setString(1, ad.getNIC());
			ps.setString(2, ad.getName());
			ps.setString(3, ad.getPsw());
			int result=ps.executeUpdate();
			System.out.println(result);
			if(result==1) {
				String re ="You have login successfully";
				request.setAttribute("Success", re);
				RequestDispatcher  rd = request.getRequestDispatcher("/adminLogin.jsp");
				rd.forward(request, response);
			}
			else {
				String re ="Register Again";
				request.setAttribute("Success", re);
				RequestDispatcher  rd = request.getRequestDispatcher("/adminReg.jsp");
				rd.forward(request, response);
			}
			
		
		} catch (SQLException e) {
			System.out.println(e);
			String re ="Duplicate NIC number >>>> Register Again ";
			request.setAttribute("Success", re);
			RequestDispatcher  rd = request.getRequestDispatcher("/adminReg.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
		}
		
		
	}


