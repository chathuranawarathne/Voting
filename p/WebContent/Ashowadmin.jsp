<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="DB.dbConnectr" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GH packages</title>
	
	<style>
		#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #8c8c8c;
    color: white;
}
</style>
	



	
	<link rel="stylesheet" type="text/css" href="CSS/Header&Footer.css">
	<link rel="stylesheet" type="text/css" href="CSS/NavigationBar.css">
	<link rel="stylesheet" type="text/css" href="CSS/Buttons.css">
	<link rel="stylesheet" type="text/css" href="CSS/admin.css">
	<link rel="stylesheet" type="text/css" href="CSS/slidbar.css">
	

	
</head>
<body>
	<header style="height:90px;">
		<div name="header" class="fixHeader" >
			<div style="padding:0px">
				 	<% 
				 	if(session.getAttribute("user")!=null){
						%>
							<form height=""action="Alogout" method="POST">
							<button type="submit" name="logout" class="button4 button5" align="right"><%=session.getAttribute("user")%> | |Admin |Logout</button>
							</form>					
						<%
						
					}else{
						%>
						<form height=""action="adminLogin.jsp" method="POST">
						<button type="submit" name="logout" class="button4 button5" align="right">Login</button>
						</form>		
						<%			
					}
			%>
				<img src="" alt="" class="logo img-responsive" style="width: 25%;padding-bottom: 30px; ">
				<div style="height:0px;margin-bottom:05px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<img src="Images/Vote.png" style="height:150px;width:150px;margin-bottom:20px;margin-top: -75px">
			
				
			</div>
						

			</div>
				
			
			<center>
					<ul class="nav">
					 <li><a href="Home.jsp">Home</a></li>
					   <li><a href="useerreg.jsp"> Register</a></li>
					  <li><a href="result.jsp">View results</a></li>
					  <li><a href="feedback.jsp">Feed Back</a></li>
					   <li><a href="#">Contact Us</a></li>
					</ul>
			</center>
		</div>								
	</header>

	
	
	<content>
	
		<div style="height:130px;margin-top:50px ; margin-left:0px">
	
	<ul class="sidenav" style=" position: fixed;height:400px">
  <li ><a href="Ashowvoters.jsp"> Voters</a></li>
  		<ol type="I">
  			 <li><a href="Aaddvoter.jsp"> Add voters</a></li>
  		</ol>
  <li><a href="AshowParties.jsp">Parties</a></li>
  		<ol type="I">
  			 <li><a href="Aaddparties.jsp"> Add Parties</a></li>
  		</ol>
 
  <li><a href="Ashowadmin.jsp">Admin</a></li>
  		<ol type="I">
  			 <li><a href="adminReg.jsp"> Add Admin</a></li>
  		</ol>
  		 <li><a href="Aelection.jsp">Election</a></li>
  		
  <li><a href="Aresults.jsp">Result</a></li>
  <li><a href="Aresults.jsp">Feed Back</a></li>
</ul>
</div>
	
<div style="margin-left:200px;margin-right:100px ;margin-top:-100px;margin-bottom:200px;">
	<table id="customers">
		<tr>	
			<th>NIC</th>
			<th>Full name</th>
		</tr>
		
	<% 
	
	Connection con =null;
	PreparedStatement ps = null;
	
	String sql = "select * from admin";
		
	
	try {
		con = new dbConnectr().Connect();
		ps = con.prepareStatement(sql);
		ResultSet rs1= ps.executeQuery();
		
		while(rs1.next()) {
			System.out.println(rs1.getString(1));
			%>
			<tr>
				<td><%=rs1.getString(1)%></td>
				<td><%=rs1.getString(2)%></td>
			
		</tr>
				
			<%
		}
		
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	%>
	
	
	</table>
	<hr>
	<h4 style="font-family: Trebuchet MS", Arial, Helvetica, sans-serif;">Delete admin</h4>
	<div style="height:150px; width:400px; margin-top:20px; margin-left:20px;">
	
		<form action="Adeleteadmin" style="border-style: groove;height:100px;width:300px" align="center" method="POST">
		
			<h4 style="font-family: Trebuchet MS", Arial, Helvetica, sans-serif;">Enter admin NIC/name</h4>
			<hr>
  			<input list="browsers" name="admin">
  			<datalist id="browsers">
  			<% 
	
	 con =null;
	 ps = null;
	
	 String sql1 = "select * from admin";
		
	
	try {
		con = new dbConnectr().Connect();
		ps = con.prepareStatement(sql);
		ResultSet  rs = ps.executeQuery();
		
		while(rs.next()) {
			%>
			
			   <option width="100%" value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>	
			<%
		}
		
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	%>
	
  			
   				
   				 
 		 </datalist>
  	
  <input type="submit" value="Delete admin">
  <h4 style="font-family: Trebuchet MS", Arial, Helvetica, sans-serif;">${delete}<h4>
  
</form>
 
	</div>
	<hr>
	<h4 style="font-family: Trebuchet MS", Arial, Helvetica, sans-serif;">Search admin</h4>
	<div style="height:120px; width:400px; margin-top:20px; margin-left:20px;">
	
		<form action="Asearchadmin" style="border-style: groove;height:100px;width:300px" align="center" method="POST">
		
			<h4 style="font-family: Trebuchet MS", Arial, Helvetica, sans-serif;">Enter admin NIC</h4>
			<hr>
  			<input list="browsers" name="admin">
  			<datalist id="browsers">
  			<% 
	
	 con =null;
	 ps = null;
	
	  sql = "select * from admin";
		
	
	try {
		con = new dbConnectr().Connect();
		ps = con.prepareStatement(sql);
		ResultSet  rs = ps.executeQuery();
		
		while(rs.next()) {
			%>
			
			   <option width="100%" value="<%=rs.getString(1)%>"><%=rs.getString(1)%></option>	
			<%
		}
		
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	%>
	 </datalist>
  	
  <input type="submit" value="search admin">
  <h4 style="font-family: Trebuchet MS", Arial, Helvetica, sans-serif;">${search}<h4>
  </form>
	</div>
  		<table id="customers">
		<tr>			
			<th>NIC</th>
			<th>Full name</th>
			
		</tr>
   				<tr>			
				<td>${NIC}</td>
				<td>${Name}</td>		
		</tr>
   			</table>	 
 		
  

 <hr>
	<h4 style="font-family: Trebuchet MS", Arial, Helvetica, sans-serif;">Update admin</h4>
	<div style="height:120px; width:400px; margin-top:20px; margin-left:20px;">
	
		<form action="AupdateAdmin" style="border-style: groove;height:100px;width:600px" align="center" method="POST">
		
			
			<h5 style="font-family: Trebuchet MS", Arial, Helvetica, sans-serif;">select  options</h5>
			<hr>
  			<input list="browsers" name="admin">
  			<datalist id="browsers">
  			<% 
	
	 con =null;
	 ps = null;
	
	  sql = "select * from admin";
		
	
	try {
		con = new dbConnectr().Connect();
		ps = con.prepareStatement(sql);
		ResultSet  rs = ps.executeQuery();
		
		while(rs.next()) {
			%>
			
			   <option width="100%" value="<%=rs.getString(1)%>"><%=rs.getString(1)%></option>	
			<%
		}
		
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	%>
	 </datalist>
 	<select name="name">
 	 	<option value="NIC">NIC</option>
 	 	<option value="Name">name</option>
 		
	</select>
  
  <input type="text" name="value" value="Enter value">
 
  		
  <input type="submit" value="Go">
  
  <h4 style="font-family: Trebuchet MS", Arial, Helvetica, sans-serif;">${update}<h4>
  </form>
  
	</div>
	
	
</div>
			
	</content>
	






			
	
	
	<footer>
		<div name="footer" class="fixFooter">
					<i class="fa fa-facebook-f" style="font-size:20px;float:left">&nbsp;&nbsp;</i>
					<i class="fa fa-twitter" style="font-size:20px;float:left">&nbsp;&nbsp;</i>
					<i class="fa fa-google-plus" style="font-size:20px;float:left">&nbsp;&nbsp;</i>
					
					<a href="adminLogin.jsp" target="mainFrame"><button name="homeFooter" type="button" class="button button1" style="float:right">Admin</button></a>
					<a href="#" target="mainFrame"><button name="cntUs" type="button" class="button button1 " style="float:right">Contact Us</button></a>
					<a href="#" target="mainFrame"><button name="help" type="button" class="button button1" style="float:right">Help/FAQ</button></a>
					<a href="#" target="mainFrame"><button name="urAccnt" type="button" class="button button1" style="float:right">Your Account</button></a>
					<a href="Home.jsp" target="mainFrame"><button name="homeFooter" type="button" class="button button1" style="float:right">Home</button></a>
					
				
					<br>
				
					<center>
					<a href="#" ><button name="userAgree" type="button" class="button2 button3 " >User Agreement</button></a>
					<a href="#" ><button name="privacy" type="button" class="button2 button3" >Privacy</button></a>
					
					<br>
					<p style="font-size:8px">Copyright &#169; 2018 Online Polling System.All Rights Reserved.</p>
					</center>
		</div>
		
	</footer>
</body>
</html>