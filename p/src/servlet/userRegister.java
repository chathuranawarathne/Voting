package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.crypto.spec.DESedeKeySpec;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import controllers.voterreg;
import models.voter;

/**
 * Servlet implementation class userRegister
 */
public class userRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userRegister() {
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
		String tnumber =request.getParameter("tnumber");
		String NIC =request.getParameter("NIC");		
		String city =request.getParameter("city");
		String email =request.getParameter("email");
		String psw =request.getParameter("psw");
		String district =request.getParameter("district");
		
		System.out.println(psw);
		
		voter vr  = new voter();
		vr.setFname(fname);
		vr.setCity(city);
		vr.setDistrict(district);
		vr.setEmail(email);
		vr.setNIC(NIC);
		vr.setPassword(psw);
		vr.setTnumber(tnumber);
		
		
		System.out.println(vr);
		
		//System.out.println(fname+"\n"+ sname+"\n"+ NIC+"\n"+ city+"\n"+ email+"\n");
		try {
			System.out.println("1");
			int result=voterreg.addvoter(vr);
			System.out.println("2");
			System.out.println(result);
			System.out.println("3");
			String re ="Register successfully";
			request.setAttribute("Success", re);
			RequestDispatcher  rd = request.getRequestDispatcher("/userLogin.jsp");
			rd.forward(request, response);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("4");
			e.printStackTrace();
			System.out.println("5");
		}
	}

}
