package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnectr {
	Connection conn = null;
	
	public Connection Connect() {
		String conURL = "jdbc:mysql://localhost:3306/voting_system?autoReconnect=true&useSSL=false";
		String conUN  = "root";
		String conPW = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(conURL,conUN,conPW);
			//System.out.println("Connection success");
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
