<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/base.css">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<%@page import="java.util.List" %>
<%@page import="com.apn.sefma.dao.Tffamily" %>
<%@page import="com.apn.sefma.DataProvider" %>
<%
	List<Tffamily> families = DataProvider.getFamilies();
%>


<title>Collections of regulogs classified by transcription factors</title>
<link rel="stylesheet" type="text/css" href="styles/base.css" />
</head>
<body>
<div id="page">
	<%@ include file="/sefma_header.jsp" %>
	<div id="content"> 
		<div >
			<div class="introduction">
				<h1>Collections of signatures classified by Transcription Factor Families</h1> 
 				<h2>
 					<b>Description goes here<b>
 				</h2>
			</div>
 			
			<div class="vspace_separator"></div>

			<div>	
			<table class="stattbl">
				<caption></caption>
				<thead>
					<tr>
						<th class="sup_column2"></th>						
						<th class="sup_column1" colspan="4">Data Statistics</th>
						<th class="sup_column2">Studied</th>
					</tr>						
					<tr>						
						<th style="text-align: left"> Transcription Factor Families</th>
						<th style="text-align: center">Signatures</th>
						<th style="text-align: center">POGs</th>
						<th style="text-align: center">Motifs</th>
						<th style="text-align: center">Transcription Factors</th>
						<th style="text-align: center">Genomes</th>					
					</tr>					
				</thead>						            				
				<tbody>
					<% for(com.apn.sefma.dao.Tffamily family : families){%>
								
					<tr>
						<td style="padding-left: 7px; text-align: left" > 
							<a href="signature_family.jsp?tffamilyId=<%= family.getTfFamilyId() %>" > <%=family.getName() %></a> 
						</td>
						<td><%=family.getSignatureCount() %></td>
						<td> <%=family.getPogCount() %></td>
						<td> <%=family.getMotifCount() %></td>
						<td> <%=family.getTfsCount() %> </td>
						<td> <%=family.getGenomeCount() %></td>
					</tr>
					<%} %>
				</tbody>
			</table>
		</div>
	</div>
		
	</div>
	<%@ include file="/sefma_footer.jsp" %>
</div>
</body>
</html>