package DB;


import java.sql.Connection;

import java.sql.SQLException;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;







public class DBConnection {
	private String url="jdbc:mysql://localhost:3306/teastdb";
	private String user ="root";
	private String password ="";
	
	public Connection getConnection()  {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection)DriverManager.getConnection(url,user,password);
			System.out.println("Coonection to DB success!!");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
		
	}
	
}
/*

public class DBConnection {
	

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
	
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teastdb","root","");
	
		PreparedStatement statement = conn.prepareStatement("select * from names");
	
	
		ResultSet result = statement.executeQuery();
			
		while(result.next())
		{
			System.out.println(result.getString(1)+ "vhuo" +result.getString(2));
		}

	}
	
}
/*

public class DBConnection {
	private String url="jdbc:mysql://localhost:8083/teastdb";
	private String user ="root";
	private String password ="";
	private Connection con;
	
	public Connection getConnection() throws ClassNotFoundException , SQLException  {
		
		Class.forName("com.mysql.jdbc.Driver");
		con = (Connection)DriverManager.getConnection(url,user,password);
		System.out.println("Coonection to DB success!!");
		
		return con;
	}
	
	public static void main(String[] args) {
		
		try {
			new DBConnection().getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}*/
