


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
	
	
	
	<div style="margin-left:120px;margin-right:120px ;margin-top:40px;">
			
			<img src="Images/llogo.png" align="middlesssss"style="height:280px;width:100%;margin-bottom:0px;margin-top: -65px">
				 		
	<div style="margin-left: 100px;margin-bottom:10px">
		 
		<marquee><h1 style="color:red">Welcome to Online Voting website!</h1></marquee>
		<h3 align="center"> ${Success}</h3><h3 align="center"  style="color:red"> ${Succe}</h3>
</div>
<div style="margin-left: 25px;margin-bottom:100px">
<p> 
Onine Voting is the process bt which an individual is encouraged and enabled to fully develop his or her potential,it may also serve the purpose of equipping the individual with what is necessary to be a productive member of society.Through teaching and learning the individual aquires and develops knowladge and skills.</p>
<p>
The term Voting is often used to refer to elect candidate(see below).How ever the world's broader meaning covers a range of ecperiences,from formal learning to the building of understanding and knowladge through day to day experiences. Ultimately,all that we experience serves as a form of education.
</p>
<p>
It is widely accepted that the process of education is lifelong.studies have shown that the child already in uetero is educated by the experiences it is exposed to ..
</p>
</p>
	<form action="userLogin.jsp" method="POST">
				 			<a target="mainFrame"><button type="submit" name="logout" class="nav" align="Center">Click here to Vote</button></a>
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