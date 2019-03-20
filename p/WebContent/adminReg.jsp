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

	<div style="margin-left:200px;margin-right:100px ;margin-top:-100px;margin-bottom:100px; ">
		 			
		<form action="adminReg" style="border:1px solid #ccc" name="myforms" onsubmit="return fromvalidate()" method="post">
  <div style="  padding: 56px ; margin-bottom" class="container" >
  <h2 align="center">Signup Form</h2></br>
   <h3 align="center" style="color:red">${Success}</h3>
	<label><b> Name</b></label>
    <input  style="width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;" type="text" placeholder="Enter full name" name="fname" required onclick=>
	
	<label><b>NIC number</b></label>
    <input  style="width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;" type="text" placeholder="Enter NIC number" name="NIC" required >
	
	
    <label><b>Password</b></label>
    <input style="width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;"  type="password" placeholder="Enter Password" name="psw" required>

    <label><b>Repeat Password</b></label>
    <input style="width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;"  type="password" placeholder="Repeat Password" name="psw-repeat" required>
    <input style=""  type="checkbox" checked="checked"> Remember me
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>


      <button style=" background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%; padding: 14px 20px;
    background-color: #f44336;"  type="button" class="cancelbtn">Cancel</button>
	
      <button style=" background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;float: left;
    width: 50%;"  type="submit" class="signupbtn">Sign Up</button>
    
      <button style=" background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;float: right;
    width: 50%;"  type="reset" class="signupbtn">Reset</button>
    </div>
  </div>
</form>
					
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