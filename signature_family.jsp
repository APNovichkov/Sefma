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
<%@page import="java.util.List" %>
<%@page import="com.apn.sefma.dao.MotifCluster" %>
<%@page import="com.apn.sefma.dao.Tffamily" %>
<%@page import="com.apn.sefma.dao.Domain" %>
<%@page import="com.apn.sefma.DataProvider" %>

<% 
	String value = request.getParameter("tffamilyId");
	int tfFamilyId = Integer.parseInt(value);
	Tffamily tffamily = DataProvider.getFamily(tfFamilyId);
	List<MotifCluster> clusters = DataProvider.getMotifClusters(tfFamilyId);
	List<Domain> domains = DataProvider.getDomains(tfFamilyId);
	
%>
<body>

<div id="page">
	
	<%@ include file="/sefma_header.jsp" %>
	<div id="content"> 
		<div>
			<div class="introduction">
				<h1>Signatures for a single Transcritpion Factor Family</h1> 
 			</div>
			
			<div class="sig-header">
				<div class="sig-column-1 col-md-6"><p>Transcription Factor Family</p></div>
				<div class="sig-column-2 col-md-6"><p>General Statistics<p></div>
			</div>	
			
			<div class="sig-info">
				<div class="family-name-wrapper col-md-6">
					<div class="col-md-12 family-name">
						<h3><%= tffamily.getName() %></h3>
						<p>Domains:
						<%for(Domain domain: domains){ %>
							<%=domain.getName() %> ,
						<%} %>
						</p>
					</div>
					
				</div>
				
				<div class="general-stat col-md-6 jumbotron">
					<ul class="general-stat-list" style="list-style-type: none">
						<li>Total Signatures: <%= tffamily.getSignatureCount() %></li>
						<li>Total POGs: <%= tffamily.getPogCount() %></li>
						<li>Total Motifs: <%= tffamily.getMotifCount() %></li>
						<li>Total Transcription Factors: <%= tffamily.getTfsCount() %></li>
						<li>Total Genomes: <%= tffamily.getGenomeCount() %></li>
						
					</ul>
				</div>
			</div>
			
			<div class="col-md-12 family-name-description">
				<p>LexA family of transcription factors includes highly conserved master regulators of the SOS (DNA damage) 
				 stress response in Bacteria. Most SOS genes encode proteins involved in DNA protection, repair and 
				 replication [18825275]. Under non-stress conditions, the LexA repressor binds a palindromic DNA operator in promoter
				 regions of target genes, thus preventing their expression.</p>
			</div>
			
			
			
			<table class="sigtable">
				<caption></caption>
				<thead>
					<tr>
						<th class="sig-table-column2"></th>						
						<th class="sig-table-column1" colspan="3">Statistics(#)</th>
						<th class="sig-table-column2">Studied(#)</th>
					</tr>						
					<tr>						
						<th style="text-align: center">Signature Logo (Link)</th>
						<th style="text-align: center">Motifs</th>
						<th style="text-align: center">Sites</th>
						<th style="text-align: center">POGs</th>
						<th style="text-align: center">Genomes</th>					
					</tr>					
				</thead>						            				
				<tbody>
					<tr>
						<td style="text-align: left; width: 100px; border-bottom: 1px solid #CCCCCC;">
							<a href="signature.jsp">
								<img src="images/example_logo.png" style="padding-right: 40px"/>
							</a>
						</td>
						<td style="text-align: center; border-bottom: 1px solid #CCCCCC;">420</td>
						<td style="text-align: center; padding-left: 10px; border-bottom: 1px solid #CCCCCC;">1290</td>
						<td style="text-align: center; border-bottom: 1px solid #CCCCCC;">80</td>
						<td style="text-align: center; border-bottom: 1px solid #CCCCCC;">20</td>
					</tr>
					<tr>
						<td style="text-align: left; width: 100px; border-bottom: 1px solid #CCCCCC;">
							<img src="images/example_logo.png" style="padding-right: 40px"/>
						</td>
						<td style="text-align: center; border-bottom: 1px solid #CCCCCC;">130</td>
						<td style="text-align: center; padding-left: 10px; border-bottom: 1px solid #CCCCCC;">700</td>
						<td style="text-align: center; border-bottom: 1px solid #CCCCCC;">90</td>
						<td style="text-align: center; border-bottom: 1px solid #CCCCCC;">10</td>
					</tr>
				</tbody>
				
			</table>
		</div>
	</div>
	
	<%@ include file="/sefma_footer.jsp" %>
</div>
</body>
</html>