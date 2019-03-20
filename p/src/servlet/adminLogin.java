package servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
 * Servlet implementation class adminLogin
 */
public class adminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminLogin() {
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
		System.out.println("post ekat awa");
		String NIC1 =request.getParameter("NIC");
		String pwd=request.getParameter("pwd");
		
		System.out.println(pwd);
		String Pass = pwd;
		System.out.println(Pass);
		MessageDigest md;
		
		try {
			md =MessageDigest.getInstance("MD5");
			md.update(pwd.getBytes());
			byte[] b = md.digest();
			StringBuffer sb = new StringBuffer();
			for(byte b1:b) {
				sb.append(Integer.toHexString(b1 & 0xff).toString());
			}
			Pass = sb.toString();
			System.out.println("9");
			System.out.println(Pass);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		Connection con =null;
		PreparedStatement ps = null;
		
		System.out.println("1  "+Pass);


		try {
			String dpwd = null;
			 con = new dbConnectr().Connect();
			 String sql="select Password from admin where NIC='"+NIC1+"'";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println("10");
			System.out.println(ps);
			System.out.println("11");
			System.out.println(rs);
			System.out.println("12");
			
			rs.next();
			dpwd = rs.getString("Password");
			System.out.println(dpwd);
			System.out.println("2  "+Pass);

			
			if(Pass.equals(dpwd)) {
				
				HttpSession session1 = request.getSession();
				session1.setAttribute("user", NIC1);
				System.out.println("session");
				System.out.println(session1.getAttribute("user"));
			String re ="You have login successfully";
			request.setAttribute("Success", re);
			RequestDispatcher  rd = request.getRequestDispatcher("/AshowParties.jsp");
			rd.forward(request, response);
			}
			else {
				
				String re ="Invalid Password";
				request.setAttribute("Success", re);
				RequestDispatcher  rd = request.getRequestDispatcher("/adminLogin.jsp");
				rd.forward(request, response);
			}
			     
			
		} catch (Exception e) {
			String re ="Invalid Login";
			request.setAttribute("Success", re);
			RequestDispatcher  rd = request.getRequestDispatcher("/adminLogin.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
		
	}
	}


