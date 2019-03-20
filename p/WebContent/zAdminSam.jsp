<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GH packages</title>
	
	



	
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
					if(session.getAttribute("user")==null){
						%>
							<form height=""action="vlogout" method="POST">
							<button type="submit" name="logout" class="button4 button5" align="right"><i><%=session.getAttribute("user")%></i> |Logout</button>
							</form>					
						<%
						
					}
					else{
						%>
						<form height=""action="userLogin.jsp" method="POST">
						<button type="submit" name="logout" class="button4 button5" align="right"> Login to vote</button>
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
					 <li><a href="home.html">Home</a></li>
					  <li><a href="gallery.php">Voter Registration</a></li>
					  <li><a href="package.php">View results</a></li>
					  <li><a href="contact.php">Contact Us</a></li>
					</ul>
			</center>
		</div>								
	</header>

	
	
	<content>
	
	<<div style="height:100px;margin-top:70px ; margin-left:0px">
	<ul class="sidenav" style=" position: fixed;">
  <li><a href="Ashowvoters.jsp"> VOTERS</a></li>
  		<ol type="I">
  			 <li><a href="Aaddvoter.jsp"> ADD VOTERS</a></li>
  		</ol>
  <li><a href="AshowParties.jsp">PARTIES</a></li>
  		<ol type="I">
  			 <li><a href="Aaddparties.jsp"> ADD PARTIES</a></li>
  		</ol>
  <li><a href="#ADD PARTY">ELECTION</a></li>
  		
  <li><a href="#REMOVE PARTY">RESULT</a></li>
  <li><a href="Ashowadmin.jsp">ADMIN</a></li>
  		<ol type="I">
  			 <li><a href="adminReg.jsp"> ADD ADMIN</a></li>
  		</ol>
  <li><a href="AfeedBack.jsp">FEED BACK</a></li>
</ul>
</div>
	
<div style="margin-left:200px;margin-right:100px ;margin-top:-100px;margin-bottom:0px;">
	
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