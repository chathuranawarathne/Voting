package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DB.dbConnectr;
import models.voter;

public class voterreg {
	
	public static int addvoter(voter vr) throws SQLException {
		int result =0;
		Connection con =null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO voter(Fname, Tnumber,District,City,Email,Password,NIC) VALUES (?,?,?,?,?,?,?)";
		try {
			con = new dbConnectr().Connect();
			ps = con.prepareStatement(sql);
			
//			ps.setString(1, vr.getVoterID());
			ps.setString(1, vr.getFname());
			ps.setString(2, vr.getTnumber());
			ps.setString(3, vr.getDistrict());
			ps.setString(4, vr.getCity());
			ps.setString(5, vr.getEmail());
			ps.setString(6, vr.getPassword());
			ps.setString(7, vr.getNIC());
			System.out.println(ps);
			result=ps.executeUpdate();
			System.out.println(result);
			return result;
		} finally {
			if(ps !=null) {
				ps.close();
			}
			if(con !=null) {
				con.close();
			}
		}
	
		
	}

}
