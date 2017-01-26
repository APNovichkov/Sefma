<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/base.css">
<title>header</title>
</head>
<body>
	<!-- Start header -->
	<div class="wrapper">
	
		<div class="header">	
	    
		            <div class="sefma-logo" style="margin-bottom: 5px;"><a href="index.jsp"><img src="images/sefma_logo.png" alt="Regprecise Logo"/></a></div>
	                
	                <h1 class="sefma-slogan"> Collection of Automatically Predicted Inferences of Signatures in Prokaryotic Genomes
	                	<div class="sefma-version">-- version 1.0 --</div> 
	                </h1>
			         <div id="searchblock">
	  				<form method="post" action="search.jsp" id="searchform">
	    				<input type="text" onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;" value="Search gene/regulator" title="Search regulator" name="name" style="color: gray;"/>
	  				</form>
	
	        		</div>
	        <!-- Start main_nav -->
	        	<div id="main_nav">
	                <ul>
	                    	<li class="notselected"><a href="index.jsp" id="home">home</a></li>
	                    	<li class="notselected"><a href="index.jsp" id="customalignment">transcription factor families</a></li>
<!-- 	                    <li class="notselected"><a href="propagations.jsp">propagated</a></li>
	                    	<li class="notselected"><a href="browse_regulogs.jsp" id="browse">browse</a></li>    
 -->	                    <li class="notselected"><a href="contacts.jsp" id="contact">contact us</a></li>
	                    	<li class="notselected"><a href="help.jsp" id="help">help</a></li>
	                </ul>
	        	</div>
	<!-- END main_nav -->
	
		</div>
	</div>
	<div class="clear"></div>
	<!-- End header -->
</body>
</html>