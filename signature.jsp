<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css.map]">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css.map">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css.map">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css.map">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/base.css">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Collections of regulogs classified by transcription factors</title>
<link rel="stylesheet" type="text/css" href="styles/base.css" />
</head>
<body>
<div id="page">
	<%@ include file="/sefma_header.jsp" %>
	<div id="content"> 
		<div>
			<div class="signature-header">
				<div class="signature-introduction col-md-6">
					<h1>LexA Signature #3</h1>
					
					<div class="signature-info col-md-5">
 						<ul class="signature-info-list" style="list-style-type: bullet">
							<li>Total Sites: 560</li>
							<li>Total Motifs: 230</li>
							<li>Signature Id: 3</li>
							<li><span class="glyphicon glyphicon-exclamation-sign"></span></li>
						</ul>
 					</div> 
 				</div>
 			
 				<div class="signature-logo col-md-6 jumbotron">
 					<img src="images/example_logo.png"/>
 				
 				</div>
 	
 			
 			</div>
			
 			
 			<div class="signature-body-header">
 				<div class="signature-column-2 col-md-3"><h3>Motif Tree<h3></div>
				<div class="signature-column-1 col-md-9"><h3>Statistics<h3></div>
			</div>
			
			<div class="signature-body">
				<div class="svg-tree col-md-3">
					<svg style="margin-top: 20px;" height="500px" width="300px">
						<line x1="20" y1="313" x2="50" y2="313" style="stroke:grey;stroke-width:2" />
						<line x1="50" y1="405" x2="50" y2="225" style="stroke:grey;stroke-width:2" />
						<line x1="50" y1="225" x2="80" y2="225" style="stroke:grey;stroke-width:2" />
						<line x1="80" y1="85" x2="80" y2="313" style="stroke:grey;stroke-width:2" />
						<line x1="80" y1="85" x2="110" y2="85" style="stroke:grey;stroke-width:2" />
						<text x="115" y="89">1-1</text>
						<line x1="80" y1="199" x2="110" y2=199 style="stroke:grey;stroke-width:2" />
						<text x="115" y="204">30-2</text>
						<line x1="80" y1="313" x2="110" y2="313" style="stroke:grey;stroke-width:2" />
						<text x="115" y="318">5-1</text>		
					</svg>
				</div>
			
				<div class="single-signature-table col-md-9">
					<table >
						<caption></caption>
						<thead>
							<tr>						
								<th style="text-align: center" >Logo</th>
								<th style="text-align: center" ># of Sites</th>
								<th style="text-align: center; padding-left: 30px;">E-value</th>
								<th style="text-align: center; padding-left: 30px">Meme Index </span></th>
							</tr>					
						</thead>						            				
	 					<tbody>
							<tr>
								<td style="text-align: center; width: 100px;  border-bottom: 1px solid #CCCCCC;">
									<img src="images/example_logo.png" style="padding-right: 40px"/>
								</td>
								
								<td style="text-align: center; padding-left: 6px; border-bottom: 1px solid #CCCCCC;">
								<a href="motif.jsp">24</a>
								</td>
								<td style="text-align: center; padding-left: 35px; border-bottom: 1px solid #CCCCCC;">.8</td>
								<td style="text-align: center; padding-left: 35px; border-bottom: 1px solid #CCCCCC;">1</td>
								
							</tr>
							<tr>
								<td style="text-align: center; width: 100px; border-bottom: 1px solid #CCCCCC;">
									<img src="images/example_logo.png" style="padding-right: 40px"/>
								</td>
								<td style="text-align: center; padding-left: 6px; border-bottom: 1px solid #CCCCCC;">
								<a href="motif.jsp">34</a>
								</td>
								<td style="text-align: center; padding-left: 35px; border-bottom: 1px solid #CCCCCC;">.3</td>
								<td style="text-align: center; padding-left: 35px; border-bottom: 1px solid #CCCCCC;">2</td>
								
							</tr>
							<tr>
								<td style="text-align: center; width: 100px;  border-bottom: 1px solid #CCCCCC;">
									<img src="images/example_logo.png" style="padding-right: 40px"/>
								</td>
								<td style="text-align: center; padding-left: 6px; border-bottom: 1px solid #CCCCCC;">
								<a href="motif.jsp">22</a>
								</td>
								<td style="text-align: center; padding-left: 35px; border-bottom: 1px solid #CCCCCC;">.9</td>
								<td style="text-align: center; padding-left: 35px; border-bottom: 1px solid #CCCCCC;">2</td>
								
							</tr>
						</tbody>
					</table>
					
				</div>
			
			</div>
		</div>
	</div>
	<%@ include file="/sefma_footer.jsp" %>
	
</div>
</body>
</html>