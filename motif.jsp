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
<title>Collections of regulogs classified by transcription factors</title>
<link rel="stylesheet" type="text/css" href="styles/base.css" />
</head>
<body>
<div id="page">

	<%@ include file="/sefma_header.jsp" %>
	<div id="content" class="motif-content"> 
		
		
		<div class="motif-introduction">
			<h1>Profile of Sites of motif: 1-1</h1> 
				<div id="propblock">
					<table class="motif-info-table">
						<caption class="motif-info-table-caption">Properties</caption>						
						<tbody>
							<tr>
								<td class="first">Family Name:</td>
								<td>LexA</td>
							</tr>
							<tr>
								<td class="first">E-Value:</td>
								<td>.5</td>
							</tr>
							<tr>
								<td class="first">Number of Sites:</td>
								<td>20</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div id="logoblock" style="margin-top: 20px;">
					<img style="width: 250px" src="images/example_logo.png"/>
				</div>
		</div> 
		
 		
		<div id="data">
				<div class="motif-table-caption">Transcription factor binding sites</div> 
					<table class="motif-table">
						<tbody>
						<tr>
							<th style="	text-align: left; padding-left: 25px;">Genome</th>
							<th style="	text-align: left;">Locus Tag</th>
							<th>Name</th>
							<th>Taxonomy Id</th>
							<th>Sequence</th>
						</tr>
						
						<tr> 						
							<td colspan="6" style="text-align: left; font-style:italic; background: #EEE" >
								
							</td>
						</tr>								
						
						<tr> 
							<td style="	text-align: left; padding-left: 42px;">Hi</td>
							<td style="	text-align: left; padding-left: 16px;">Hello</td>
							<td style="	text-align: center;">Bonjour</td>
							<td style="	text-align: center;">Hola</td>
							<td class="sequence">ATCGTGTGATT</td>
						</tr>
						
						</tbody>
					</table>
			</div>
	</div>
	<%@ include file="/sefma_footer.jsp" %>
</div>
</body>
</html>