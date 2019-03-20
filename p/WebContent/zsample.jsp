


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	
	<title>GH packages</title>
	
	



	
	<link rel="stylesheet" type="text/css" href="CSS/Header&Footer.css">
	<link rel="stylesheet" type="text/css" href="CSS/NavigationBar.css">
	<link rel="stylesheet" type="text/css" href="CSS/Buttons.css">
	

	
</head>
<body>
	<header style="height:90px;">
		<div name="header" class="fixHeader" >
			<div style="padding:0px">
				 
					<%
					if(session.getAttribute("username")!=null){
						%>
							<form height=""action="vlogout" method="POST">
							<button type="submit" name="logout" class="button4 button5" align="right"><i><%=session.getAttribute("username")%></i> |Logout</button>
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
					  <li><a href="gallery.php">Voter Login</a></li>
					  <li><a href="package.php">View results</a></li>
					  <li><a href="contact.php">Feed Back</a></li>
					   <li><a href="contact.php">Contact Us</a></li>
					</ul>
			</center>
		</div>								
	</header>
	<content>
	
	
	<div style="margin-left:120px;margin-right:120px ;margin-top:40px;">
	
	
	






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